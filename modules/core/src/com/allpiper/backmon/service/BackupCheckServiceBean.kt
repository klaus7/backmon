package com.allpiper.backmon.service

import com.allpiper.backmon.entity.backup.BackupFolder
import com.allpiper.backmon.entity.backup.BackupTarget
import com.allpiper.backmon.entity.backup.check.BackupCheck
import com.allpiper.backmon.entity.backup.check.BackupCheckAttributeMode
import com.allpiper.backmon.entity.backup.check.BackupCheckBackupFoldersCompareMode
import com.allpiper.backmon.entity.backup.check.BackupCheckFilesCompareMode
import com.allpiper.backmon.service.check.CheckException
import com.haulmont.cuba.core.global.DataManager
import org.slf4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.inject.Inject

@Service(BackupCheckService.NAME)
class BackupCheckServiceBean : BackupCheckService {
    @Autowired
    private lateinit var dataManager: DataManager

    @Autowired
    private lateinit var fileDataFetcherService: FileDataFetcherService

    @Inject
    private lateinit var log: Logger

    override fun checkAll() {
        dataManager.load(BackupCheck::class.java).list().forEach {
            if (it.active == true) {
                check(it)
            }
        }
    }

    override fun check(check: BackupCheck) {
        val origin = check.compareOrigin?.let { dataManager.reload(it, "backupTarget-view") }
                ?: throw Exception("origin is null")
        val target = check.compareTarget?.let { dataManager.reload(it, "backupTarget-view") }
                ?: throw Exception("target is null")
        val attributeMode = check.getCheckAttributeMode() ?: throw Exception("attributeMode is null")
        val checkFilesMode = check.getCheckFilesMode()
        val checkFoldersMode = check.getCheckFoldersMode()
        val checkCaption = check.toCaptionString()

        check.lastResultHadErrors = false
        check.lastResult = ""

        fileDataFetcherService.updateFiles(origin)
        fileDataFetcherService.updateFiles(target)

        val logBuilder = StringBuilder()
        origin.folders?.forEach folderLoop@{ originFolder ->
            try {
                val targetFolder = target.folders?.firstOrNull { e -> cleanFolderPath(origin, originFolder) == cleanFolderPath(target, e) }
                if (targetFolder == null) {
                    when (checkFoldersMode) {
                        BackupCheckBackupFoldersCompareMode.IGNORE_MISSING -> return@folderLoop
                        BackupCheckBackupFoldersCompareMode.ORIGIN_EXISTS_IN_TARGET -> {
                            throw CheckException(
                                    "$checkCaption: origin folder '${originFolder.folderPath}' doesn't " +
                                            "exist in target ${target.name}")
                        }
                        //                        BackupCheckBackupFoldersCompareMode.ORIGN_HAS_SAME_AS_TARGET -> TODO()
                    }
                    return@folderLoop
                }

                dataManager.reload(originFolder, "backupFolder-files-view").files?.forEach fileLoop@{ originFile ->
                    var sizeIsProblem = false
                    val targetFile = dataManager.reload(targetFolder, "backupFolder-files-view").files?.firstOrNull { e ->
                        when (attributeMode) {
                            BackupCheckAttributeMode.FILE_PATH_AND_SIZE -> {
                                val pathEquals = e.filePath == originFile.filePath
                                val sizeEquals = e.sizeInBytes == originFile.sizeInBytes
                                if (pathEquals && !sizeEquals) {
                                    sizeIsProblem = true
                                }
                                return@firstOrNull pathEquals && sizeEquals
                            }
                        }
                        return@firstOrNull false
                    }
                    if (targetFile == null) {
                        when (checkFilesMode) {
                            BackupCheckFilesCompareMode.ORIGIN_EXISTS_IN_TARGET -> {
                                if (sizeIsProblem) {
                                    throw CheckException(
                                            "$checkCaption: origin file '${originFile.filePath}' has different size in target folder '${targetFolder.folderPath}'")
                                }
                                throw CheckException(
                                        "$checkCaption: origin file '${originFile.filePath}' doesn't " +
                                                "exist in target folder '${targetFolder.folderPath}'")
                            }
                            //BackupCheckFilesCompareMode.ORIGN_HAS_SAME_AS_TARGET -> TODO()
                        }
                        return@fileLoop
                    }
                }

            } catch (e: Exception) {
                log.info(e.message)
                logBuilder.append(e.message).append("\n")
                check.lastResultHadErrors = true
            }
        }
        check.lastResult = logBuilder.toString()
        dataManager.commit(check)

    }

    private fun cleanFolderPath(target: BackupTarget, folder: BackupFolder) : String? {
        target.parentFolder?.let {
            return folder.folderPath?.removePrefix(it)
        }
        return folder.folderPath
    }


}
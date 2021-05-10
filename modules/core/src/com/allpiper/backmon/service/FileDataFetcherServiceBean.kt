package com.allpiper.backmon.service

import com.allpiper.backmon.entity.backup.BackupTarget
import com.allpiper.backmon.fetcher.FileDataFetcherType
import com.allpiper.backmon.service.fetcher.LocalFileDataFetcherAction
import com.haulmont.cuba.core.global.DataManager
import org.slf4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import javax.inject.Inject

@Service(FileDataFetcherService.NAME)
class FileDataFetcherServiceBean : FileDataFetcherService {
    @Autowired
    private lateinit var dataManager: DataManager

    @Autowired
    private lateinit var localFileDataFetcherAction: LocalFileDataFetcherAction

    @Inject
    private lateinit var log: Logger

    override fun updateFiles(target: BackupTarget) {
        fetchFiles(target)
    }

    override fun fetchFiles(target: BackupTarget) {
        log.info("Entering fetchFiles(target={})", target)
        val fetcher = target.fileDataFetcher ?: throw Exception("no file data fetcher for target=$target")

        target.folders?.forEach { folder ->
            log.info("Process folder {}", folder)
            val folder = dataManager.reload(folder, "backupFolder-files-view")
            val files = folder.files ?: ArrayList()
            files.forEach {
                dataManager.remove(it)
            }
            files.clear()

            when (fetcher.getType()) {
                FileDataFetcherType.LOCAL -> localFileDataFetcherAction.fetch(target, folder)
            }

            folder.lastScan = LocalDateTime.now()
            dataManager.commit(folder)
        }
        log.info("Leaving fetchFiles(target={})", target)
    }
}

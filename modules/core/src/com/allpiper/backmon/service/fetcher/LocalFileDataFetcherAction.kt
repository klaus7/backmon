package com.allpiper.backmon.service.fetcher

import com.allpiper.backmon.entity.backup.BackupFile
import com.allpiper.backmon.entity.backup.BackupFolder
import com.allpiper.backmon.entity.backup.BackupTarget
import com.haulmont.cuba.core.global.DataManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.nio.file.*
import java.nio.file.attribute.BasicFileAttributes

@Component
class LocalFileDataFetcherAction {
    @Autowired
    private lateinit var dataManager: DataManager

    fun fetch(target: BackupTarget, folder: BackupFolder) {
        Files.walkFileTree(Paths.get(folder.folderPath), object : SimpleFileVisitor<Path>() {
            override fun visitFile(file: Path?, attrs: BasicFileAttributes?): FileVisitResult {
                if (file != null && attrs != null) {
                    dataManager.create(BackupFile::class.java).also {
                        it.backupFolder = folder
                        it.filePath = file.toString()
                        it.sizeInBytes = attrs.size()
                        // it.md5sum
                        dataManager.commit(it)
                    }
                }
                return super.visitFile(file, attrs)
            }
        })

    }

}
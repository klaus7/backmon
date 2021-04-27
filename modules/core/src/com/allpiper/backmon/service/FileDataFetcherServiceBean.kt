package com.allpiper.backmon.service

import com.allpiper.backmon.entity.backup.BackupTarget
import com.allpiper.backmon.fetcher.FileDataFetcherType
import com.allpiper.backmon.service.fetcher.LocalFileDataFetcherAction
import com.haulmont.cuba.core.global.DataManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service(FileDataFetcherService.NAME)
class FileDataFetcherServiceBean : FileDataFetcherService {
    @Autowired
    private lateinit var dataManager: DataManager

    @Autowired
    private lateinit var localFileDataFetcherAction: LocalFileDataFetcherAction

    override fun fetchFiles(target: BackupTarget) {
        val fetcher = target.fileDataFetcher ?: return

        target.folders?.forEach { folder ->
            val files = folder.files ?: ArrayList()
            files.forEach {
                dataManager.remove(it)
            }
            files.clear()

            when (fetcher.getType()) {
                FileDataFetcherType.LOCAL -> localFileDataFetcherAction.fetch(target, folder)
            }

            folder.lastScan = LocalDateTime.now()
        }
    }
}

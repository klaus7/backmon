package com.allpiper.backmon.service

import com.allpiper.backmon.entity.backup.BackupTarget

interface FileDataFetcherService {
    companion object {
        const val NAME = "backmon_FileDataFetcherService"
    }

    fun fetchFiles(target: BackupTarget)
}
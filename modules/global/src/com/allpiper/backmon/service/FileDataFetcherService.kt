package com.allpiper.backmon.service

import com.allpiper.backmon.entity.backup.BackupTarget

interface FileDataFetcherService {
    companion object {
        const val NAME = "backmon_FileDataFetcherService"
    }

    fun updateFiles(target: BackupTarget)
    fun fetchFiles(target: BackupTarget)
}
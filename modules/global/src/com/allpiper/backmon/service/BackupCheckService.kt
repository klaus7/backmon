package com.allpiper.backmon.service

import com.allpiper.backmon.entity.backup.check.BackupCheck

interface BackupCheckService {
    companion object {
        const val NAME = "backmon_BackupCheckService"
    }

    fun check(check: BackupCheck)
    fun checkAll()

}
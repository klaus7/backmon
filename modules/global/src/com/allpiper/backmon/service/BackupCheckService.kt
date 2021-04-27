package com.allpiper.backmon.service

interface BackupCheckService {
    companion object {
        const val NAME = "backmon_BackupCheckService"
    }

    fun check()

}
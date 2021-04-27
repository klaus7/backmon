package com.allpiper.backmon.service

import com.allpiper.backmon.entity.backup.check.BackupCheck
import com.haulmont.cuba.core.global.DataManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service(BackupCheckService.NAME)
class BackupCheckServiceBean : BackupCheckService {
    @Autowired
    private lateinit var dataManager: DataManager

    @Autowired
    private lateinit var fileDataFetcherService: FileDataFetcherService

    override fun check() {
        dataManager.load(BackupCheck::class.java).list().forEach { check ->

            val origin = check.compareOrigin
            val target = check.compareTarget
            val attributeMode = check.getCheckAttributeMode()

            fileDataFetcherService

        }
    }


}
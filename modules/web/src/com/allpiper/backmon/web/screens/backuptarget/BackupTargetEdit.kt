package com.allpiper.backmon.web.screens.backuptarget

import com.haulmont.cuba.gui.screen.*
import com.allpiper.backmon.entity.backup.BackupTarget
import com.allpiper.backmon.fetcher.FileDataFetcher
import com.haulmont.cuba.core.global.DataManager
import javax.inject.Inject

@UiController("backmon_BackupTarget.edit")
@UiDescriptor("backup-target-edit.xml")
@EditedEntityContainer("backupTargetDc")
@LoadDataBeforeShow
class BackupTargetEdit : StandardEditor<BackupTarget>() {
    @Inject
    private lateinit var dataManager: DataManager

    @Subscribe
    private fun onInitEntity(event: InitEntityEvent<BackupTarget>) {
        event.entity.fileDataFetcher = dataManager.create(FileDataFetcher::class.java)
    }


}
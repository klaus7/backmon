package com.allpiper.backmon.web.screens.backuptarget

import com.haulmont.cuba.gui.screen.*
import com.allpiper.backmon.entity.backup.BackupTarget
import com.allpiper.backmon.service.FileDataFetcherService
import com.haulmont.cuba.gui.components.Action
import com.haulmont.cuba.gui.components.GroupTable
import javax.inject.Inject

@UiController("backmon_BackupTarget.browse")
@UiDescriptor("backup-target-browse.xml")
@LookupComponent("backupTargetsTable")
@LoadDataBeforeShow
class BackupTargetBrowse : StandardLookup<BackupTarget>() {
    @Inject
    private lateinit var fileDataFetcherService: FileDataFetcherService

    @Inject
    private lateinit var backupTargetsTable: GroupTable<BackupTarget>

    @Subscribe("backupTargetsTable.fetchFiles")
    private fun onBackupTargetsTableFetchFiles(event: Action.ActionPerformedEvent) {
        backupTargetsTable.singleSelected?.let {
            fileDataFetcherService.fetchFiles(it)
        }
    }
}
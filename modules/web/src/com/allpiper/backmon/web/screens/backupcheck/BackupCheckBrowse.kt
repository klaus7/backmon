package com.allpiper.backmon.web.screens.backupcheck

import com.haulmont.cuba.gui.screen.*
import com.allpiper.backmon.entity.backup.check.BackupCheck
import com.allpiper.backmon.service.BackupCheckService
import com.haulmont.cuba.core.global.DataManager
import com.haulmont.cuba.gui.Dialogs
import com.haulmont.cuba.gui.Notifications
import com.haulmont.cuba.gui.components.Action
import com.haulmont.cuba.gui.components.GroupTable
import javax.inject.Inject

@UiController("backmon_BackupCheck.browse")
@UiDescriptor("backup-check-browse.xml")
@LookupComponent("backupChecksTable")
@LoadDataBeforeShow
class BackupCheckBrowse : StandardLookup<BackupCheck>() {
    @Inject
    private lateinit var backupCheckService: BackupCheckService

    @Inject
    private lateinit var backupChecksTable: GroupTable<BackupCheck>

    @Inject
    private lateinit var dataManager: DataManager

    @Inject
    private lateinit var dialogs: Dialogs

    @Inject
    private lateinit var notifications: Notifications

    @Subscribe("backupChecksTable.runCheck")
    private fun onBackupChecksTableRunCheck(event: Action.ActionPerformedEvent) {
        backupChecksTable.singleSelected?.let {
            backupCheckService.check(it)
            screenData.loadAll()
            dataManager.reload(it, "_local").let {
                val lastResult = it.lastResult
                if (!lastResult.isNullOrEmpty()) {
                    dialogs.createMessageDialog()
                            .withMessage(lastResult)
                            .show()
                } else {
                    notifications.create(Notifications.NotificationType.TRAY)
                            .withCaption("Checks succeeded")
                            .show()
                }

            }
        }
    }

}
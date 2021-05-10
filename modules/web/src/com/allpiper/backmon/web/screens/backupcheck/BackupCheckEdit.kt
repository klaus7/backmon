package com.allpiper.backmon.web.screens.backupcheck

import com.haulmont.cuba.gui.screen.*
import com.allpiper.backmon.entity.backup.check.BackupCheck

@UiController("backmon_BackupCheck.edit")
@UiDescriptor("backup-check-edit.xml")
@EditedEntityContainer("backupCheckDc")
@LoadDataBeforeShow
class BackupCheckEdit : StandardEditor<BackupCheck>()
package com.allpiper.backmon.web.screens.backupfolder

import com.haulmont.cuba.gui.screen.*
import com.allpiper.backmon.entity.backup.BackupFolder

@UiController("backmon_BackupFolder.edit")
@UiDescriptor("backup-folder-edit.xml")
@EditedEntityContainer("backupFolderDc")
@LoadDataBeforeShow
class BackupFolderEdit : StandardEditor<BackupFolder>()
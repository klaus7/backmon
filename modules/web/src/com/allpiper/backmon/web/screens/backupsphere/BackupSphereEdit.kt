package com.allpiper.backmon.web.screens.backupsphere

import com.haulmont.cuba.gui.screen.*
import com.allpiper.backmon.entity.backup.BackupSphere

@UiController("backmon_BackupSphere.edit")
@UiDescriptor("backup-sphere-edit.xml")
@EditedEntityContainer("backupSphereDc")
@LoadDataBeforeShow
class BackupSphereEdit : StandardEditor<BackupSphere>()
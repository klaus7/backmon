package com.allpiper.backmon.web.screens.backupsphere

import com.haulmont.cuba.gui.screen.*
import com.allpiper.backmon.entity.backup.BackupSphere

@UiController("backmon_BackupSphere.browse")
@UiDescriptor("backup-sphere-browse.xml")
@LookupComponent("backupSpheresTable")
@LoadDataBeforeShow
class BackupSphereBrowse : StandardLookup<BackupSphere>()
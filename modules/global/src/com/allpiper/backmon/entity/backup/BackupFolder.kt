package com.allpiper.backmon.entity.backup

import com.haulmont.chile.core.annotations.Composition
import com.haulmont.chile.core.annotations.NamePattern
import com.haulmont.cuba.core.entity.StandardEntity
import com.haulmont.cuba.core.entity.annotation.OnDelete
import com.haulmont.cuba.core.global.DeletePolicy
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotNull

@NamePattern("%s %s|folderPath,lastScan")
@Table(name = "BACKMON_BACKUP_FOLDER")
@javax.persistence.Entity(name = "backmon_BackupFolder")
open class BackupFolder : StandardEntity() {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "BACKUP_TARGET_ID")
    var backupTarget: BackupTarget? = null

    @NotNull
    @Column(name = "FOLDER_PATH", nullable = false)
    var folderPath: String? = null

    @Column(name = "LAST_SCAN")
    var lastScan: LocalDateTime? = null

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "backupFolder")
    var files: MutableList<BackupFile>? = mutableListOf()

    companion object {
        private const val serialVersionUID = -8822591519050372771L
    }
}
package com.allpiper.backmon.entity.backup.check

import com.allpiper.backmon.entity.backup.BackupTarget
import com.haulmont.cuba.core.entity.StandardEntity
import javax.persistence.*
import javax.validation.constraints.NotNull

@Table(name = "BACKMON_BACKUP_CHECK")
@javax.persistence.Entity(name = "backmon_BackupCheck")
open class BackupCheck : StandardEntity() {
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "COMPARE_ORIGIN_ID")
    var compareOrigin: BackupTarget? = null

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "COMPARE_TARGET_ID")
    var compareTarget: BackupTarget? = null

    @NotNull
    @Column(name = "CHECK_ATTRIBUTE_MODE", nullable = false)
    private var checkAttributeMode: String? = BackupCheckAttributeMode.FILE_PATH_AND_SIZE.id

    @NotNull
    @Column(name = "CHECK_FILES_MODE", nullable = false)
    private var checkFilesMode: String? = BackupCheckFilesCompareMode.ORIGIN_EXISTS_IN_TARGET.id

    @NotNull
    @Column(name = "CHECK_FOLDERS_MODE", nullable = false)
    private var checkFoldersMode: String? = BackupCheckBackupFoldersCompareMode.ORIGIN_EXISTS_IN_TARGET.id

    fun getCheckFoldersMode(): BackupCheckBackupFoldersCompareMode? = checkFoldersMode?.let { BackupCheckBackupFoldersCompareMode.fromId(it) }

    fun setCheckFoldersMode(checkFoldersMode: BackupCheckBackupFoldersCompareMode?) {
        this.checkFoldersMode = checkFoldersMode?.id
    }

    fun getCheckFilesMode(): BackupCheckFilesCompareMode? = checkFilesMode?.let { BackupCheckFilesCompareMode.fromId(it) }

    fun setCheckFilesMode(checkFilesMode: BackupCheckFilesCompareMode?) {
        this.checkFilesMode = checkFilesMode?.id
    }

    fun getCheckAttributeMode(): BackupCheckAttributeMode? = checkAttributeMode?.let { BackupCheckAttributeMode.fromId(it) }

    fun setCheckAttributeMode(checkAttributeMode: BackupCheckAttributeMode?) {
        this.checkAttributeMode = checkAttributeMode?.id
    }

    companion object {
        private const val serialVersionUID = -1685619944554324742L
    }
}
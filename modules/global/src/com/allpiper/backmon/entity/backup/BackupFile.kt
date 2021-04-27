package com.allpiper.backmon.entity.backup

import com.haulmont.cuba.core.entity.BaseIdentityIdEntity
import com.haulmont.cuba.core.entity.HasUuid
import java.util.*
import javax.persistence.*

@Table(name = "BACKMON_BACKUP_FILE")
@javax.persistence.Entity(name = "backmon_BackupFile")
open class BackupFile : BaseIdentityIdEntity(), HasUuid {
    @Column(name = "UUID")
    private var uuid: UUID? = null

    @Column(name = "FILE_PATH", length = 1024)
    var filePath: String? = null

    @Column(name = "SIZE_IN_BYTES")
    var sizeInBytes: Long? = null

    @Column(name = "MD5SUM")
    var md5sum: String? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "BACKUP_FOLDER_ID")
    var backupFolder: BackupFolder? = null

    override fun setUuid(uuid: UUID?) {
        this.uuid = uuid
    }

    override fun getUuid(): UUID? = uuid

    companion object {
        private const val serialVersionUID = -3791520741625154724L
    }
}
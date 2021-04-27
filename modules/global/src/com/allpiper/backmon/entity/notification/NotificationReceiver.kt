package com.allpiper.backmon.entity.notification

import com.allpiper.backmon.entity.backup.BackupSphere
import com.haulmont.chile.core.annotations.NamePattern
import com.haulmont.cuba.core.entity.StandardEntity
import javax.persistence.*

@NamePattern(value = "%s|name")
@Table(name = "BACKMON_NOTIFICATION_RECEIVER")
@javax.persistence.Entity(name = "backmon_NotificationReceiver")
open class NotificationReceiver : StandardEntity() {
    @Column(name = "NAME")
    var name: String? = null

    @Column(name = "EMAIL")
    var email: String? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BACKUP_SPHERE_ID")
    var backupSphere: BackupSphere? = null

    companion object {
        private const val serialVersionUID = -7223728880090996724L
    }
}
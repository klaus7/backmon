package com.allpiper.backmon.entity.backup

import com.allpiper.backmon.entity.notification.NotificationReceiver
import com.haulmont.chile.core.annotations.NamePattern
import com.haulmont.cuba.core.entity.StandardEntity
import javax.persistence.Column
import javax.persistence.OneToMany
import javax.persistence.Table

@NamePattern(value = "%s|name")
@Table(name = "BACKMON_BACKUP_SPHERE")
@javax.persistence.Entity(name = "backmon_BackupSphere")
open class BackupSphere : StandardEntity() {
    @Column(name = "NAME")
    var name: String? = null

    @OneToMany(mappedBy = "backupSphere")
    var targets: MutableList<BackupTarget>? = mutableListOf()

    @OneToMany(mappedBy = "backupSphere")
    var notificationReceivers: MutableList<NotificationReceiver>? = mutableListOf()

    companion object {
        private const val serialVersionUID = -7304282836522292900L
    }
}
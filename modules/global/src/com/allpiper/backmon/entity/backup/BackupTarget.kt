package com.allpiper.backmon.entity.backup

import com.allpiper.backmon.fetcher.FileDataFetcher
import com.haulmont.chile.core.annotations.Composition
import com.haulmont.chile.core.annotations.NamePattern
import com.haulmont.cuba.core.entity.StandardEntity
import com.haulmont.cuba.core.entity.annotation.OnDelete
import com.haulmont.cuba.core.global.DeletePolicy
import javax.persistence.*
import javax.validation.constraints.NotNull

@NamePattern(value = "%s|name")
@Table(name = "BACKMON_BACKUP_TARGET")
@javax.persistence.Entity(name = "backmon_BackupTarget")
open class BackupTarget : StandardEntity() {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BACKUP_SPHERE_ID")
    var backupSphere: BackupSphere? = null

    @NotNull
    @Column(name = "ACTIVE", nullable = false)
    var active: Boolean? = true

    @Column(name = "NAME")
    var name: String? = null

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "backupTarget")
    var folders: MutableList<BackupFolder>? = mutableListOf()

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FILE_DATA_FETCHER_ID")
    var fileDataFetcher: FileDataFetcher? = null

    companion object {
        private const val serialVersionUID = -7023117796241849692L
    }
}
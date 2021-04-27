package com.allpiper.backmon.fetcher

import com.allpiper.backmon.entity.backup.BackupTarget
import com.haulmont.chile.core.annotations.NamePattern
import com.haulmont.cuba.core.entity.StandardEntity
import javax.persistence.*
import javax.validation.constraints.NotNull

@NamePattern(value = "%s|name")
@Table(name = "BACKMON_FILE_DATA_FETCHER")
@Entity(name = "backmon_FileDataFetcher")
open class FileDataFetcher : StandardEntity() {
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "fileDataFetcher")
    var backupTarget: BackupTarget? = null

    @NotNull
    @Column(name = "TYPE_", nullable = false)
    private var type: String? = FileDataFetcherType.LOCAL.id

    @Column(name = "NAME")
    var name: String? = null

    @Lob
    @Column(name = "SCRIPT")
    var script: String? = null

    @Column(name = "SCRIPT_LANGUAGE", length = 32)
    var scriptLanguage: String? = "bash"


    fun getType(): FileDataFetcherType? = type?.let { FileDataFetcherType.fromId(it) }

    fun setType(type: FileDataFetcherType?) {
        this.type = type?.id
    }

    companion object {
        private const val serialVersionUID = 1009521193590148358L
    }
}
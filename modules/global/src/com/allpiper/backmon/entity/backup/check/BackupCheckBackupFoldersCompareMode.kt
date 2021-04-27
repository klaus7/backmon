package com.allpiper.backmon.entity.backup.check

import com.haulmont.chile.core.datatypes.impl.EnumClass

enum class BackupCheckBackupFoldersCompareMode(private val id: String) : EnumClass<String> {
    IGNORE_MISSING("igm"),
    ORIGIN_EXISTS_IN_TARGET("oext"),
    ORIGN_HAS_SAME_AS_TARGET("oeqt");

    override fun getId() = id

    companion object {

        @JvmStatic
        fun fromId(id: String): BackupCheckBackupFoldersCompareMode? = BackupCheckBackupFoldersCompareMode.values().find { it.id == id }
    }
}
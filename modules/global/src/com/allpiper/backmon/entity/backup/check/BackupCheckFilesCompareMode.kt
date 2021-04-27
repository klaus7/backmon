package com.allpiper.backmon.entity.backup.check

import com.haulmont.chile.core.datatypes.impl.EnumClass

enum class BackupCheckFilesCompareMode(private val id: String) : EnumClass<String> {
    ORIGN_HAS_SAME_AS_TARGET("oeqt"),
    ORIGIN_EXISTS_IN_TARGET("oext");

    override fun getId() = id

    companion object {

        @JvmStatic
        fun fromId(id: String): BackupCheckFilesCompareMode? = BackupCheckFilesCompareMode.values().find { it.id == id }
    }
}
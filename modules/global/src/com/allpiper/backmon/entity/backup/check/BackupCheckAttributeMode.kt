package com.allpiper.backmon.entity.backup.check

import com.haulmont.chile.core.datatypes.impl.EnumClass

enum class BackupCheckAttributeMode(private val id: String) : EnumClass<String> {
    FILE_PATH_AND_SIZE("fs"),
//    CHECKSUM("crc")
    ;

    override fun getId() = id

    companion object {

        @JvmStatic
        fun fromId(id: String): BackupCheckAttributeMode? = BackupCheckAttributeMode.values().find { it.id == id }
    }
}
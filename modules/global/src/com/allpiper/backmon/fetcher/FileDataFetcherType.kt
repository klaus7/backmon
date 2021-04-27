package com.allpiper.backmon.fetcher

import com.haulmont.chile.core.datatypes.impl.EnumClass

enum class FileDataFetcherType(private val id: String) : EnumClass<String> {
    LOCAL("L");

    override fun getId() = id

    companion object {

        @JvmStatic
        fun fromId(id: String): FileDataFetcherType? = FileDataFetcherType.values().find { it.id == id }
    }
}
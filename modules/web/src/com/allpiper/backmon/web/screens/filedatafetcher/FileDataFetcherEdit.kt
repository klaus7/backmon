package com.allpiper.backmon.web.screens.filedatafetcher

import com.haulmont.cuba.gui.screen.*
import com.allpiper.backmon.fetcher.FileDataFetcher

@UiController("backmon_FileDataFetcher.edit")
@UiDescriptor("file-data-fetcher-edit.xml")
@EditedEntityContainer("fileDataFetcherDc")
@LoadDataBeforeShow
class FileDataFetcherEdit : StandardEditor<FileDataFetcher>()
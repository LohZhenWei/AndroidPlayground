package com.sample.android.playground.library.util

import android.content.Context

interface FileUtil {

    fun getPath(): String
}

class FileUtilImpl(
    private val context: Context
) : FileUtil {
    override fun getPath(): String {
        return context.filesDir.path
    }

}
package com.sample.android.playground.library.hilt

import android.content.Context
import com.sample.android.playground.library.util.FileUtil
import com.sample.android.playground.library.util.FileUtilImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UtilModule {

    @Provides
    fun provideFileUtil(context: Context): FileUtil {
        return FileUtilImpl(context)
    }
}
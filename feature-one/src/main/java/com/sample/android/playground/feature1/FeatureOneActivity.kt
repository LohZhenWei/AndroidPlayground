package com.sample.android.playground.feature1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sample.android.playground.library.util.FileUtil
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class FeatureOneActivity : AppCompatActivity() {

    @Inject
    lateinit var fileUtil: FileUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature_one)
        Timber.d("test12333333- ${fileUtil.getPath()}")
    }
}
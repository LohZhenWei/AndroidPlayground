package com.sample.android.playground.ui.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sample.android.playground.R
import com.sample.android.playground.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpNavGraph(R.navigation.activity_main_graph)
    }
}
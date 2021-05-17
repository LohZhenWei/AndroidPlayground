package com.sample.android.playground.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment

import com.sample.android.playground.R

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }

    fun setUpNavGraph(graphId: Int) {
        val newNavGraph = NavHostFragment.create(graphId)
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_container, newNavGraph)
            .setPrimaryNavigationFragment(newNavGraph)
            .commit()
    }

    override fun onBackPressed() {
        val navHostFragment =
            supportFragmentManager.primaryNavigationFragment as NavHostFragment
        val fragment =
            navHostFragment.childFragmentManager.primaryNavigationFragment as BaseFragment<*>
        fragment.popBackStack()
    }
}
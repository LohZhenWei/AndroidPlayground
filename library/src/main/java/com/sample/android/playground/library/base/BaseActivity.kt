package com.sample.android.playground.library.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_base)
    }

    /*  fun setUpNavGraph(graphId: Int) {

          val navController: NavHostFragment =
              supportFragmentManager
                  .findFragmentById(R.id.nav_container) as NavHostFragment
          val graph = navController.navController.navInflater.inflate(graphId)
          navController.navController.graph = graph

          // some issue using this method to inflate graph.
          //should inflate using xml way.
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
              navHostFragment.childFragmentManager.primaryNavigationFragment as BaseFragment<*, *>
          fragment.popBackStack()
      }
      */
}

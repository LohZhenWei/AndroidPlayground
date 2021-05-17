package com.sample.android.playground.ui.coroutine

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.sample.android.playground.R
import com.sample.android.playground.ui.MainViewModel
import com.sample.android.playground.ui.State
import com.sample.android.playground.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment : BaseFragment<MainViewModel>() {

    override val viewModel: MainViewModel by viewModels()

    override fun getLayoutResId(): Int = R.layout.fragment_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        initObserver()
    }

    private fun initListener() {
        btn_state_a.setOnClickListener { viewModel.changeToStateA() }
        btn_state_b.setOnClickListener { viewModel.changeToStateB() }
        btn_to_next_screen.setOnClickListener { findNavController().navigate(R.id.action_to_secondScreenFragment) }
    }

    private fun initObserver() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.taskEvent.collect {
                tv_state.text = when (it) {
                    is State.StateA -> {
                        "State A"
                    }
                    State.StateB -> "State B"
                }
            }
        }
    }


}
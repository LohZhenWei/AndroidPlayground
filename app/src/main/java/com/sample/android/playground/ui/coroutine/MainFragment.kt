package com.sample.android.playground.ui.coroutine

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sample.android.playground.R
import com.sample.android.playground.databinding.FragmentMainBinding
import com.sample.android.playground.extension.collectFlow
import com.sample.android.playground.ui.MainViewModel
import com.sample.android.playground.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>() {

    override val viewModel: MainViewModel by viewModels()

    override fun getLayoutResId(): Int = R.layout.fragment_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        initObserver()
    }

    private fun initListener() {
        binding.apply {
            btnMutableLiveData.setOnClickListener { viewModel.triggerMutableLiveData() }
            btnSingleLiveEvent.setOnClickListener { viewModel.triggerSingleLiveEvent() }
            btnStateFlow.setOnClickListener { viewModel.triggerStateFlow() }
            btnSharedFlow.setOnClickListener { viewModel.triggerShareFlow() }
            btnFlow.setOnClickListener { triggerFlow() }
            btnToNextScreen.setOnClickListener { viewModel.triggerGoNextScreen() }
        }
    }

    private fun initObserver() {
        viewModel.mutableLiveData.observe(viewLifecycleOwner) {
            showToast("Toast from Mutable Live Data")
        }
        viewModel.singleLiveEvent.observe(viewLifecycleOwner) {
            showToast("Toast from Single Live Event")
        }
        collectFlow(viewModel.stateFlow) {
            if (it.isNotEmpty())
                showToast("Toast from StateFlow")
        }
        collectFlow(viewModel.shareFlow) {
            showToast("Toast from share flow")
        }
        collectFlow(viewModel.goNextScreen) {
            findNavController().navigate(R.id.action_to_secondScreenFragment)
        }
    }

    private fun triggerFlow() {
        collectFlow(viewModel.triggerFlow()) {
            binding.tvState.text = it.toString()
        }
    }

    private fun showToast(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }

    override fun popBackStack() {
        activity?.finish()
    }
}
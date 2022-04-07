package com.sample.android.playground.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

abstract class BaseFragment<viewBinding : ViewDataBinding, ViewModelType : BaseViewModel> :
    Fragment() {

    abstract val viewModel: ViewModelType

    private lateinit var _binding: viewBinding
    protected val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return DataBindingUtil.inflate<viewBinding>(inflater, getLayoutResId(), container, false)
            .apply {
                _binding = this
                lifecycleOwner = viewLifecycleOwner
            }.root
    }

    @LayoutRes
    abstract fun getLayoutResId(): Int

    open fun popBackStack() {
        findNavController().popBackStack()
    }

    override fun onDestroy() {
        binding.unbind()
        super.onDestroy()
    }
}
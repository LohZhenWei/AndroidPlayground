package com.sample.android.playground.ui.coroutine

import androidx.fragment.app.viewModels
import com.sample.android.playground.R
import com.sample.android.playground.databinding.FragmentSecondScreenBinding
import com.sample.android.playground.ui.base.BaseFragment

class SecondScreenFragment : BaseFragment<FragmentSecondScreenBinding, MainViewModel>() {

    override val viewModel: MainViewModel by viewModels()
    override fun getLayoutResId(): Int = R.layout.fragment_second_screen

}
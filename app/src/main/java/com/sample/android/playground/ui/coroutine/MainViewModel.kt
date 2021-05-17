package com.sample.android.playground.ui

import androidx.lifecycle.viewModelScope
import com.sample.android.playground.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : BaseViewModel() {

    val stateFlow = MutableStateFlow("")

    private val taskEventChannel = Channel<State>()

    val taskEvent = taskEventChannel.receiveAsFlow()

    fun changeToStateA() {
        viewModelScope.launch {
            taskEventChannel.send(State.StateA)
        }
    }

    fun changeToStateB() {
        viewModelScope.launch {
            taskEventChannel.send(State.StateB)
        }
    }
}

sealed class State() {
    object StateA : State()
    object StateB : State()
}
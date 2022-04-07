package com.sample.android.playground.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sample.android.playground.model.SingleLiveEvent
import com.sample.android.playground.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
) : BaseViewModel() {


    private val _mutableLiveData = MutableLiveData<String>()
    val mutableLiveData: LiveData<String> = _mutableLiveData

    private val _singleLiveEvent = SingleLiveEvent<String>()
    val singleLiveEvent: LiveData<String> = _singleLiveEvent

    private val _stateFlow = MutableStateFlow("")
    val stateFlow = _stateFlow.asStateFlow()

    private val _shareFlow = MutableSharedFlow<String>()
    val shareFlow = _shareFlow.asSharedFlow()

    private val _goNextScreen = MutableSharedFlow<Any?>()
    val goNextScreen = _goNextScreen.asSharedFlow()

    fun triggerMutableLiveData() {
        _mutableLiveData.value = "Mutable Live data"
    }

    fun triggerSingleLiveEvent() {
        _singleLiveEvent.value = "Single Live Event"
    }

    fun triggerStateFlow() {
        _stateFlow.value = "State Flow"
    }

    fun triggerShareFlow() {
        viewModelScope.launch {
            _shareFlow.emit("Shared Flow")
        }
    }

    fun triggerGoNextScreen() {
        viewModelScope.launch {
            _goNextScreen.emit(null)
        }
    }

    fun triggerFlow(): Flow<Int> {
        return flow {
            repeat(10) {
                emit(it + 1)
                delay(500L)
            }
        }
    }

    init {
        collectLatest()
    }

    private fun collectLatest() {
        viewModelScope.launch {
            triggerFlow().collect {
                delay(1000)
                Timber.d("Testing collect - $it")
            }
        }
        viewModelScope.launch {
            triggerFlow().collectLatest {
                delay(1000)
                Timber.d("Testing collect latest - $it")
            }
        }
    }
}
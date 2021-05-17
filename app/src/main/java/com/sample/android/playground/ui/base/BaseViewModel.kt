package com.sample.android.playground.ui.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    protected inline fun <T> CoroutineScope.launchSafely(
        showProgress: Boolean = true,
        crossinline job: suspend () -> T,
        crossinline onSuccess: suspend (T) -> Unit = {},
        crossinline onError: suspend (ex: Throwable) -> Unit = {}
    ): Job {
        return launch {
            try {
                onSuccess(job())
            } catch (ex: Throwable) {
                onError.invoke(ex)
            }
        }
    }
}
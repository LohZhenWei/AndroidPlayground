package com.sample.android.playground.hilt

import javax.inject.Qualifier

@Qualifier
annotation class IOCoroutineDispatcher

@Qualifier
annotation class MainCoroutineDispatcher

@Qualifier
annotation class DefaultCoroutineDispatcher

package com.zrz.android.swcurrency.core.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

abstract class BaseViewModel(app: Application) : AndroidViewModel(app) {

    val throwableLD: MutableLiveData<Throwable> = MutableLiveData()

    fun reportError(throwable: Throwable) {
        throwableLD.value = throwable
    }
}
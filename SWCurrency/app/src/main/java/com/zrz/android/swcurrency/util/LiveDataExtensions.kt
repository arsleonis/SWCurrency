package com.zrz.android.swcurrency.util

import androidx.lifecycle.MutableLiveData

fun <L, D> MutableLiveData<L>.addItems(data: List<D>)
    where L : MutableList<D> {
    this.value!!.addAll(data)
    this.postValue(this.value)
}
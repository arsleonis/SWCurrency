package com.zrz.android.swcurrency.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SWCurrency(
    val code: String,
    val name: String,
    val country: String,
    val rate: Double
) : Parcelable
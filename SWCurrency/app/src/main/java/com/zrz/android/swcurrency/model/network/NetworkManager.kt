package com.zrz.android.swcurrency.model.network

interface NetworkManager {

    fun doGetRequest(
        header1: String,
        header2:String,
        baseCurrency: String = "",
        secondaryCurrency: String = "",
        currenciesList: String = ""
        ) : String
}
package com.zrz.android.swcurrency.model.network

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.Request

class NetworkManagerImpl : NetworkManager {

    private val cclient = NetworkClient.getClient()

    override fun doGetRequest(
        url: String,
        baseCurrency: String,
        secondaryCurrency: String,
        currenciesList: String
    ): String {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(url)
            .get()
            .addHeader(API_HOST_KEY, API_HOST_VALUE)
            .addHeader(API_KEY_KEY, API_KEY_VALUE)
            .build()
        Log.d("ml", "-> $request")
        val response = client.newCall(request).execute()
        Log.d("ml", "---> $response")
        return response.toString()
    }

    companion object{
        const val API_HOST_KEY = "x-rapidapi-host"
        const val API_KEY_KEY = "x-rapidapi-key"
        const val API_HOST_VALUE = "fixer-fixer-currency-v1.p.rapidapi.com"
        const val API_KEY_VALUE = "62ebd6304emshcb8ec6d137fc865p1a9ff5jsn012f0c671e04"
    }
}
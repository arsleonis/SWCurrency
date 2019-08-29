package com.zrz.android.swcurrency.repository.currency

import com.zrz.android.swcurrency.entity.SWCurrency
import com.zrz.android.swcurrency.model.network.NetworkManager

class CurrencyRepositoryImpl(private val networkManager: NetworkManager) : CurrencyRepository {

    override fun requestLatestRates(baseCurrencyCode: String): List<SWCurrency> {
        val supportedSymbols = getSupportedSymbols()
        val latestRatesResponse = networkManager.doGetRequest(
            header1 = HEADER_API_HOST,
            header2 = HEADER_API_KEY,
            baseCurrency = baseCurrencyCode,
            currenciesList = supportedSymbols
        )
        return transformRatesToList(latestRatesResponse)
    }

    private fun getSupportedSymbols(): String {
        val symbolsResponse = networkManager.doGetRequest(HEADER_API_HOST, HEADER_API_KEY)
        val symbols: String =""
        // transform response to symbols
        return symbols
    }

    private fun transformRatesToList(ratesResponse: String): List<SWCurrency> {
        val currenciesList = listOf<SWCurrency>()
        // transform ratesResponse to currenciesList
        return currenciesList
    }

    companion object {
        const val HEADER_API_HOST = "fixer-fixer-currency-v1.p.rapidapi.com"
        const val HEADER_API_KEY = "62ebd6304emshcb8ec6d137fc865p1a9ff5jsn012f0c671e04"
    }
}
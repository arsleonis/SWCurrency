package com.zrz.android.swcurrency.repository.currency

import com.zrz.android.swcurrency.entity.SWCurrency
import com.zrz.android.swcurrency.model.network.NetworkManager

class CurrencyRepositoryImpl(private val networkManager: NetworkManager) : CurrencyRepository {

    override fun getLatestRates(baseCurrencyCode: String): List<SWCurrency> {
        val supportedSymbols = getSupportedSymbols()
        val latestRatesResponse = networkManager.doGetRequest(
            url = URL_LATEST_RATES,
            baseCurrency = baseCurrencyCode,
            currenciesList = supportedSymbols
        )
        return transformRatesToList(latestRatesResponse)
    }

    private fun getSupportedSymbols(): String {
        val symbolsResponse = networkManager.doGetRequest(URL_SUPPORTED_SYMBOLS)
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
        const val URL_SUPPORTED_SYMBOLS = "https://fixer-fixer-currency-v1.p.rapidapi.com/symbols"
        const val URL_LATEST_RATES = "https://fixer-fixer-currency-v1.p.rapidapi.com/latest?base=USD&symbols=GBP%2CJPY%2CEUR"
        const val URL_CONVERT = "https://fixer-fixer-currency-v1.p.rapidapi.com/convert?from=USD&to=ILS&amount=12"
    }
}
package com.zrz.android.swcurrency.feature.rate

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.zrz.android.swcurrency.core.base.BaseViewModel
import com.zrz.android.swcurrency.entity.SWCurrency
import com.zrz.android.swcurrency.repository.currency.CurrencyRepository
import com.zrz.android.swcurrency.util.extension.addItems
import java.util.concurrent.Executors

class RateViewModel(
    app: Application,
    private val currencyRepository: CurrencyRepository
    ) : BaseViewModel(app) {

    val ratesLD: MutableLiveData<MutableList<SWCurrency>> = MutableLiveData()

    init {
        ratesLD.value = mutableListOf()
    }

    fun requestLatestRates(baseCurrencyCode: String){
        val executor = Executors.newFixedThreadPool(5)
        executor.execute {
            val rates = currencyRepository.getLatestRates(baseCurrencyCode)
            ratesLD.addItems(rates)
        }
    }
}
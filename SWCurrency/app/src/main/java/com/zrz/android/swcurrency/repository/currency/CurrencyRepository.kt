package com.zrz.android.swcurrency.repository.currency

import com.zrz.android.swcurrency.entity.SWCurrency

interface CurrencyRepository {
    fun getLatestRates(baseCurrencyCode: String): List<SWCurrency>
}
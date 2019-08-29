package com.zrz.android.swcurrency.feature.rate

import android.view.View
import android.view.ViewGroup
import com.zrz.android.swcurrency.R
import com.zrz.android.swcurrency.core.base.BaseAdapter
import com.zrz.android.swcurrency.entity.SWCurrency
import com.zrz.android.swcurrency.util.inflateView

class RateAdapter : BaseAdapter<SWCurrency, RateAdapter.RateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RateViewHolder(parent.inflateView(R.layout.item_rate))

    override fun compareItemsById(): (Pair<SWCurrency, SWCurrency>) -> Boolean =
        { messagePair -> messagePair.first.country == messagePair.second.country }

    class RateViewHolder(view: View) : BaseViewHolder<SWCurrency>(view) {
        override fun onBind(currency: SWCurrency) {
        }
    }
}
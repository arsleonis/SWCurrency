package com.zrz.android.swcurrency.feature.rate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.zrz.android.swcurrency.R
import com.zrz.android.swcurrency.entity.SWCurrency
import com.zrz.android.swcurrency.feature.converter.ConverterActivity
import com.zrz.android.swcurrency.util.startNewActivity
import kotlinx.android.synthetic.main.activity_rate.*

class RateActivity : AppCompatActivity() {

    private lateinit var rateAdapter: RateAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate)
        recyclerViewInitializing()
        observeLiveData()
    }

    private fun onItemClick(currency: SWCurrency) {
        startNewActivity<ConverterActivity>(KEY_LOGIN, KEY_NAME to currency.country)
    }

    private fun recyclerViewInitializing() {
        val chatLayoutManager = LinearLayoutManager(applicationContext)
        chatLayoutManager.stackFromEnd
        rateAdapter = RateAdapter()
        rateAdapter.itemClickAction = { position, _ ->
            onItemClick(rateAdapter.rates[position])
            rvRate.apply {
                layoutManager = chatLayoutManager
                adapter = rateAdapter
            }
        }
    }

    private fun observeLiveData(){

    }

    companion object {
        const val KEY_LOGIN = "key_login"
        const val KEY_NAME = "key_name"
        const val BUNDLE_KEY = "key_bundle"
        const val INTENT_KEY = "key_intent"
    }
}

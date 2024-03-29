package com.zrz.android.swcurrency.feature.converter

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.zrz.android.swcurrency.R
import com.zrz.android.swcurrency.core.base.BaseActivity
import kotlinx.android.synthetic.main.activity_converter.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ConverterActivity : BaseActivity() {

    private val converterViewModel: ConverterViewModel by viewModel()

    override fun obtainLayoutResID(): Int = R.layout.activity_converter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        etBaseCurrency.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(text: Editable) {
                converterViewModel.requestConverterRate(
                    etBaseCurrency.text(),
                    tvRequiredCurrencyLabel.text,
                    tvBaseCurrencyLabel.text)
            }

            override fun beforeTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })

        observingAction(converterViewModel.converterRateLD, { etRequiredCurrency.text = it })
    }
}

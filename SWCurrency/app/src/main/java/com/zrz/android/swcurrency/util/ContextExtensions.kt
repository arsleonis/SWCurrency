package com.zrz.android.swcurrency.util

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

inline fun <reified A> AppCompatActivity.startNewActivity(
    intentKey: String,
    vararg extras: Pair<String, String>
)
        where A : AppCompatActivity {
    val intent = Intent(this, A::class.java)
    val list = listOf(*extras)
    if (list.isNotEmpty()) {
        val bundle = Bundle()
        list.forEach { (bundleKey, extra) ->
            bundle.putSerializable(
                bundleKey.asBundleKey(),
                extra
            )
        }
        intent.putExtra(intentKey.asIntentKey(), bundle)
    }
    startActivity(intent)
}
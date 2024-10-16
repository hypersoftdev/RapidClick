package com.hypersoft.rapidclick

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import android.os.SystemClock
import android.util.Log
import android.view.View

object Extensions {

    private var lastClickTime: Long = 0
    fun View.rapidSafeClickListener(time: Int = 300, action: () -> Unit) {
        this.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                if (SystemClock.elapsedRealtime() - lastClickTime < time) return
                else action()
                lastClickTime = SystemClock.elapsedRealtime()
            }
        })
    }

    inline fun <reified T : Parcelable> Intent.parcelable(key: String): T? = when {
        Build.VERSION.SDK_INT >= 33 -> getParcelableExtra(key, T::class.java)
        else -> @Suppress("DEPRECATION") getParcelableExtra(key) as? T
    }

    inline fun <reified T : Parcelable> Bundle.parcelable(key: String): T? = when {
        Build.VERSION.SDK_INT >= 33 -> {
            try {
                getParcelable(key, T::class.java)
            } catch (e: Exception) {
                // Log or handle exception if retrieval fails
                Log.e("BundleExt", "Error retrieving Parcelable: ${e.message}")
                null
            }
        }

        else -> @Suppress("DEPRECATION") getParcelable(key) as? T
    }

}
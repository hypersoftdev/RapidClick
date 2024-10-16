package com.hypersoft.clicker

import android.content.Context
import android.widget.Toast

object Toasty {

    fun showShort(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun showLong(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

}
package com.namnp.instagram_android.utils

import android.content.Context
import android.util.Log
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.makeText

class Utils {
    companion object {
        fun print(e: Exception) = Log.e("TAG", e.stackTraceToString())

        fun log(message: String) = Log.e("TAG", message)

        fun showMessage(
            context: Context,
            message: String?
        ) = makeText(context, message, LENGTH_LONG).show()
    }
}
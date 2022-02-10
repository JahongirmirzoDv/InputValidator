package com.example.inputvalidator

import android.content.Context
import android.widget.Toast

object ToasMaker {
    fun show(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}
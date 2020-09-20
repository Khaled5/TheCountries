package com.easyinc.thecountries.base.extentions

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}

fun View.snack(message: String, length: Int = Snackbar.LENGTH_LONG) {
    val snacks = Snackbar.make(this,message,length).also {
        it.setBackgroundTint(Color.BLACK)
        it.setTextColor(Color.WHITE)
        it.view.minimumHeight = 170

        (it.view as? Snackbar.SnackbarLayout)?.getChildAt(0)?.let { innerView ->
            innerView.minimumHeight = 170
        }
    }
    snacks.show()
}
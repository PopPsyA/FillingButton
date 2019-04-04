package com.github.devit951.fillingbutton

import android.content.Context
import android.util.AttributeSet

class InternetSensableFillingButton @kotlin.jvm.JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0): FillingButton(context, attrs, defStyle) {

    private val internetSensableButton: InternetSensableButton = InternetSensableButton(this){ isConnected ->
        when(isConnected){
            true -> onButtonFilled = lastOnButtonFilled
            false -> onButtonFilled = null
        }
    }

    private var lastOnButtonFilled: (() -> Unit)? = null

    override var onButtonFilled: (() -> Unit)? = null
        set(value) {
            if (value != null){
                lastOnButtonFilled = value
            }
            field = value
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        internetSensableButton.registerConnectionReceiver()
    }

    override fun onDetachedFromWindow() {
        internetSensableButton.unregisterReceiver()
        super.onDetachedFromWindow()
    }
}
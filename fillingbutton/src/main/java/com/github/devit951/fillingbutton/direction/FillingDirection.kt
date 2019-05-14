package com.github.devit951.fillingbutton.direction

import android.graphics.Rect
import com.github.devit951.fillingbutton.FillingButton

interface FillingDirection {
    fun drawDirection(fillingButton: FillingButton, animatedIntValue: Int)
    fun resetDirection(fillingButton: FillingButton)
}
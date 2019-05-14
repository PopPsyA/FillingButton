package com.github.devit951.fillingbutton.direction

import com.github.devit951.fillingbutton.FillingButton

class FromLeftToRightFillingDirection: FillingDirection {
    override fun drawDirection(fillingButton: FillingButton, animatedIntValue: Int) {
        fillingButton.fillingRect.right = animatedIntValue
    }

    override fun resetDirection(fillingButton: FillingButton) {
        fillingButton.fillingRect.right = 0
    }
}
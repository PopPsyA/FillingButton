package com.github.devit951.fillingbutton.direction

import com.github.devit951.fillingbutton.FillingButton

class RightToLeftFillingDirection: FillingDirection {
    override fun drawDirection(fillingButton: FillingButton, animatedIntValue: Int){
        fillingButton.fillingRect.left = fillingButton.viewWidth - animatedIntValue
    }

    override fun resetDirection(fillingButton: FillingButton) {
        fillingButton.fillingRect.left = 0
    }

    override fun trigger(fillingButton: FillingButton) = fillingButton.viewWidth
}
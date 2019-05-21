package com.github.devit951.fillingbutton.direction

import com.github.devit951.fillingbutton.FillingButton

class BottomToTopFillingDirection: FillingDirection {

    private var once = true

    override fun drawDirection(fillingButton: FillingButton, animatedIntValue: Int) {
        if (once){
            fillingButton.fillingWidthValueAnimator.setIntValues(0, fillingButton.viewHeight)
            once = false
        }
        fillingButton.fillingRect.top = fillingButton.viewHeight - animatedIntValue
    }

    override fun resetDirection(fillingButton: FillingButton) {
        fillingButton.fillingRect.top = fillingButton.viewHeight
    }

    override fun trigger(fillingButton: FillingButton) = fillingButton.viewHeight
}
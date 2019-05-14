package com.github.devit951.fillingbutton

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.support.v7.widget.AppCompatButton
import android.util.AttributeSet
import android.view.MotionEvent
import com.github.devit951.fillingbutton.direction.FillingDirection
import com.github.devit951.fillingbutton.direction.FromLeftToRightFillingDirection
import com.github.devit951.fillingbutton.direction.FromRightToLeftFillingDirection

open class FillingButton @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0): AppCompatButton(context, attrs, defStyle){

    internal var viewWidth: Int = 0
    internal var viewHeight: Int = 0
    internal val fillingRect = Rect()

    private val fillingColor: Int
    private val fillingAlpha: Int
    private val fillingDuration: Long

    private val fillingPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val fillingValueAnimator = ValueAnimator()
    private var drawProgress = false

    var fillingDirection: FillingDirection = FromLeftToRightFillingDirection()
    open var onButtonFilled: (() -> Unit)? = null

    init {
        context.obtainStyledAttributes(attrs, R.styleable.FillingButton, defStyle, 0).apply {
            fillingColor = getColor(R.styleable.FillingButton_fillColor, Color.GRAY)
            fillingAlpha = getInt(R.styleable.FillingButton_fillAlpha, 128)
            fillingDuration = getInt(R.styleable.FillingButton_fillDuration, 1500).toLong()
        }.recycle()
        fillingPaint.color = fillingColor
        fillingPaint.alpha = fillingAlpha
        fillingValueAnimator.duration = fillingDuration
        post {
            viewWidth = width
            viewHeight = height
            fillingRect.bottom = height
            fillingRect.right = viewWidth
            fillingValueAnimator.setIntValues(0, viewWidth)
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (drawProgress && onButtonFilled != null){
            canvas?.drawRect(fillingRect, fillingPaint)
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action){
            MotionEvent.ACTION_DOWN -> {
                drawProgress = true
                startFillingAnimation(fillingRect)
                return true
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                drawProgress = false
                stopFillingAnimation(fillingRect)
                return true
            }
        }
        return super.onTouchEvent(event)
    }

    private fun startFillingAnimation(rect: Rect){
        stopFillingAnimation(rect)
        fillingValueAnimator.apply {
            addUpdateListener {
                val intValue = it.animatedValue as Int
                fillingDirection.drawDirection(this@FillingButton, intValue)
                invalidate()
                if (intValue == viewWidth){
                    onButtonFilled?.invoke()
                }
            }
        }.start()
    }

    private fun stopFillingAnimation(rect: Rect){
        fillingValueAnimator.cancel()
        fillingValueAnimator.removeAllUpdateListeners()
        fillingDirection.resetDirection(this)
        invalidate()
    }
}
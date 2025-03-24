package com.example.quizmvp.screen.result
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.example.quizmvp.R
/**
 * Creator: Javohir Oromov
 * Project: QuizMVP
 * Date: 23/03/25
 * Javohir's MacBook Air
 */

class CircularProgressView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyle: Int = 0
) : View(context, attrs, defStyle) {

    private var progress = 0
    private var maxProgress = 100
    private val strokeWidth = 20f

    private val backgroundPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        color = ContextCompat.getColor(context, R.color.red)
        strokeWidth = this@CircularProgressView.strokeWidth
        strokeCap = Paint.Cap.ROUND
    }

    private val progressPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        color = ContextCompat.getColor(context, R.color.blue)
        strokeWidth = this@CircularProgressView.strokeWidth
        strokeCap = Paint.Cap.ROUND
    }

    private val rectF = RectF()

    fun setProgress(correct: Int, total: Int) {
        progress = (correct * 100) / total
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val padding = strokeWidth / 2
        rectF.set(padding, padding, width - padding, height - padding)


        canvas.drawArc(rectF, 0f, 360f, false, backgroundPaint)

        val sweepAngle = (progress * 360) / maxProgress.toFloat()
        canvas.drawArc(rectF, -90f, sweepAngle, false, progressPaint)
    }
}
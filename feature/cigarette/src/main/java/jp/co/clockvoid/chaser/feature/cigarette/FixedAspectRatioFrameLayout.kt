package jp.co.clockvoid.chaser.feature.cigarette

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.widget.FrameLayout

class FixedAspectRatioFrameLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var mAspectRatioWidth = 0
    private var mAspectRatioHeight = 0
    private var mMaxHeight = 0

    init {
        val a: TypedArray =
            context.obtainStyledAttributes(attrs, R.styleable.FixedAspectRatioFrameLayout)
        mAspectRatioWidth = a.getInt(R.styleable.FixedAspectRatioFrameLayout_aspectRatioWidth, 4)
        mAspectRatioHeight = a.getInt(R.styleable.FixedAspectRatioFrameLayout_aspectRatioHeight, 3)
        mMaxHeight = a.getDimensionPixelSize(R.styleable.FixedAspectRatioFrameLayout_maxHeight, 0)
        a.recycle()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val originalWidth = MeasureSpec.getSize(widthMeasureSpec)
        val calculatedHeight = originalWidth * mAspectRatioHeight / mAspectRatioWidth
        val finalWidth: Int = originalWidth
        val finalHeight: Int
        finalHeight = if (mMaxHeight > 0) {
            minOf(calculatedHeight, mMaxHeight)
        } else {
            calculatedHeight
        }
        super.onMeasure(
            MeasureSpec.makeMeasureSpec(finalWidth, MeasureSpec.EXACTLY),
            MeasureSpec.makeMeasureSpec(finalHeight, MeasureSpec.EXACTLY)
        )
    }
}

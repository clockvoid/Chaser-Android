package jp.co.clockvoid.chaser.core.android

import android.content.Context
import android.graphics.Rect
import android.util.DisplayMetrics
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SpacingItemDecoration(
    /**
     * Space size by dp.
     */
    private val spacingDp: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val spacingPixel = spacingDp.toFloat().dpToPixel(parent.context).toInt()
        outRect.apply {
            if (parent.getChildAdapterPosition(view) == 0) {
                top = spacingPixel
            }
            left =  spacingPixel
            right = spacingPixel
            bottom = spacingPixel
        }
    }

    private fun Float.dpToPixel(context: Context): Float =
        this * (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
}

package jp.co.clockvoid.chaser.feature.cigarette

import android.view.View
import com.xwray.groupie.viewbinding.BindableItem
import jp.co.clockvoid.chaser.core.model.Smoke
import jp.co.clockvoid.chaser.feature.cigarette.databinding.ItemChartBinding

class ChartItem(
    val items: List<Smoke>
) : BindableItem<ItemChartBinding>() {

    override fun bind(p0: ItemChartBinding, p1: Int) {
    }

    override fun getLayout(): Int {
        TODO("Not yet implemented")
    }

    override fun initializeViewBinding(p0: View): ItemChartBinding {
        TODO("Not yet implemented")
    }
}

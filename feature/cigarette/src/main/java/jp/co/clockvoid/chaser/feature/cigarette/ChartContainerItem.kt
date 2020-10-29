package jp.co.clockvoid.chaser.feature.cigarette

import android.view.View
import com.xwray.groupie.viewbinding.BindableItem
import jp.co.clockvoid.chaser.core.model.Smoke
import jp.co.clockvoid.chaser.feature.cigarette.databinding.ItemChartContainerBinding

class ChartContainerItem(
    val items: List<Smoke>
) : BindableItem<ItemChartContainerBinding>() {

    override fun bind(binding: ItemChartContainerBinding, position: Int) {

    }

    override fun getLayout(): Int = R.layout.item_chart_container

    override fun initializeViewBinding(view: View): ItemChartContainerBinding {
        return ItemChartContainerBinding.bind(view)
    }
}

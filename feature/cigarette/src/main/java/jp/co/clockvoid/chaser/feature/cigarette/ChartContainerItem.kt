package jp.co.clockvoid.chaser.feature.cigarette

import android.view.View
import com.xwray.groupie.viewbinding.BindableItem
import jp.co.clockvoid.chaser.feature.cigarette.databinding.ItemChartContainerBinding

class ChartContainerItem : BindableItem<ItemChartContainerBinding>() {

    override fun bind(binding: ItemChartContainerBinding, position: Int) {

        val items = (0..10).toList()
        binding.chartContainerViewPager.adapter = BarChartAdapter(items)
    }

    override fun getLayout(): Int = R.layout.item_chart_container

    override fun initializeViewBinding(view: View): ItemChartContainerBinding {

        return ItemChartContainerBinding.bind(view)
    }
}

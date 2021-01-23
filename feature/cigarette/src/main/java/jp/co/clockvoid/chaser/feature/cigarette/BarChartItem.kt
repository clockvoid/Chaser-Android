package jp.co.clockvoid.chaser.feature.cigarette

import android.view.View
import com.xwray.groupie.viewbinding.BindableItem
import jp.co.clockvoid.chaser.feature.cigarette.databinding.ItemBarChartBinding

class BarChartItem(
    var itemNumber: Int
) : BindableItem<ItemBarChartBinding>() {

    override fun bind(viewBinding: ItemBarChartBinding, position: Int) {

        viewBinding.numberTextView.text = itemNumber.toString()
    }

    override fun getLayout(): Int = R.layout.item_bar_chart

    override fun initializeViewBinding(view: View): ItemBarChartBinding {

        return ItemBarChartBinding.bind(view)
    }
}

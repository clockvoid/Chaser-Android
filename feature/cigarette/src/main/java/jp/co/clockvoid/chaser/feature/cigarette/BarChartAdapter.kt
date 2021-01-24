package jp.co.clockvoid.chaser.feature.cigarette

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import jp.co.clockvoid.chaser.feature.cigarette.databinding.ItemBarChartBinding

class BarChartAdapter(
    var itemNumberList: List<Int>
) : RecyclerView.Adapter<BarChartAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemBarChartBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(ItemBarChartBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val entries: List<BarEntry> = itemNumberList.map {
            BarEntry(it.toFloat(), it.toFloat() * itemNumberList[position].toFloat())
        }
        val dataSet = BarDataSet(entries, "label")
        holder.binding.barChart.apply {
            data = BarData(dataSet)
            setDrawGridBackground(false)
            setDrawBorders(false)
            keepScreenOn = true
            isHighlightPerDragEnabled = true
            isDoubleTapToZoomEnabled = false
            setPinchZoom(false)
            xAxis.apply {
                setTouchEnabled(false)
            }
            axisRight.apply {
                setTouchEnabled(false)
                labelCount = 6
                axisMinimum = 0f
            }
            axisLeft.isEnabled = false
            invalidate()
        }
    }

    override fun getItemCount(): Int = itemNumberList.size
}

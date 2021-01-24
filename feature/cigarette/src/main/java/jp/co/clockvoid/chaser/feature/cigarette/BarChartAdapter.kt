package jp.co.clockvoid.chaser.feature.cigarette

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
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

        holder.binding.numberTextView.text = itemNumberList[position].toString()
    }

    override fun getItemCount(): Int = itemNumberList.size
}

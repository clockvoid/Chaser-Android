package jp.co.clockvoid.chaser.feature.cigarette

import android.content.Context
import android.view.View
import android.widget.ImageView
import com.xwray.groupie.Item
import com.xwray.groupie.viewbinding.BindableItem
import jp.co.clockvoid.chaser.feature.cigarette.databinding.ItemAnalyticsBinding

class NumberItem(
    private val number: Int
) : BindableItem<ItemAnalyticsBinding>() {

    override fun isSameAs(other: Item<*>): Boolean = other is NumberItem

    override fun hasSameContentAs(other: Item<*>): Boolean {
        return other is NumberItem && other.number == this.number
    }

    override fun getChangePayload(other: Item<*>): Any? {
        return other is NumberItem && other.number != this.number
    }

    override fun getLayout(): Int = R.layout.item_analytics

    override fun bind(viewBinding: ItemAnalyticsBinding, position: Int) {
        viewBinding.apply {
            titleTextView.text = root.context.getString(R.string.number_of_today)
            bodyTextView.text = root.context.getString(R.string.number_format, number)
            decideSentiment(sentimentImageView, root.context)
        }
    }

    override fun initializeViewBinding(view: View): ItemAnalyticsBinding {
        return ItemAnalyticsBinding.bind(view)
    }

    private fun decideSentiment(imageView: ImageView, context: Context) {
        when {
            number > 10 -> {
                imageView.setImageResource(R.drawable.ic_sentiment_very_dissatisfied_black_24dp)
                imageView.contentDescription = context.getString(R.string.dissatisfied)
            }
            number < 5 -> {
                imageView.setImageResource(R.drawable.ic_sentiment_very_satisfied_black_24dp)
                imageView.contentDescription = context.getString(R.string.satisfied)
            }
            else ->{
                imageView.setImageResource(R.drawable.ic_sentiment_satisfied_black_24dp)
                imageView.contentDescription = context.getString(R.string.normal)
            }
        }
    }
}

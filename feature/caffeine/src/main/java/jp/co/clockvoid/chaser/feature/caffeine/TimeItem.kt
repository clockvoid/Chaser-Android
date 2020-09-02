package jp.co.clockvoid.chaser.feature.caffeine

import android.content.Context
import android.view.View
import android.widget.ImageView
import com.xwray.groupie.Item
import com.xwray.groupie.viewbinding.BindableItem
import jp.co.clockvoid.chaser.feature.caffeine.databinding.ItemAnalyticsBinding
import org.threeten.bp.Duration

class TimeItem(
    private val durationSinceLastSmoke: Duration
) : BindableItem<ItemAnalyticsBinding>() {

    override fun isSameAs(other: Item<*>): Boolean = other is TimeItem

    override fun hasSameContentAs(other: Item<*>): Boolean {
        return other is TimeItem && other.durationSinceLastSmoke == this.durationSinceLastSmoke
    }

    override fun getChangePayload(other: Item<*>): Any? {
        return other is TimeItem && other.durationSinceLastSmoke != this.durationSinceLastSmoke
    }

    override fun getLayout(): Int = R.layout.item_analytics

    override fun bind(viewBinding: ItemAnalyticsBinding, position: Int) {
        viewBinding.apply {
            titleTextView.text = root.context.getString(R.string.since_last_boost)
            bodyTextView.text = root.context.getString(
                R.string.format_hour_min,
                durationSinceLastSmoke.toHours(),
                durationSinceLastSmoke.minusHours(durationSinceLastSmoke.toHours()).toMinutes()
            )
            decideSentiment(sentimentImageView, root.context)
        }
    }

    override fun initializeViewBinding(view: View): ItemAnalyticsBinding {
        return ItemAnalyticsBinding.bind(view)
    }

    private fun decideSentiment(imageView: ImageView, context: Context) {
        when {
            durationSinceLastSmoke.toMinutes() < 30 -> {
                imageView.setImageResource(R.drawable.ic_sentiment_very_dissatisfied_black_24dp)
                imageView.contentDescription = context.getString(R.string.dissatisfied)
            }
            durationSinceLastSmoke.toHours() > 3 -> {
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

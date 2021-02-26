package jp.co.clockvoid.chaser.feature.alcohol.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import jp.co.clockvoid.chaser.feature.alcohol.R

@Composable
fun AnalyticsItem(title: String, body: String, sentimentLevel: Int, isLast: Boolean) {

    Card(
        modifier = Modifier.padding(
            bottom = if (isLast) 72.dp else 8.dp,
            start = 8.dp,
            end = 8.dp
        ),
        elevation = 4.dp
    ) {

        ConstraintLayout(constraintSet = ConstraintSet {

            val titleTextView = createRefFor("titleTextView")
            val bodyTextView = createRefFor("bodyTextView")
            val sentimentImageView = createRefFor("sentimentImageView")

            constrain(titleTextView) {
                top.linkTo(parent.top)
                bottom.linkTo(bodyTextView.top)
                start.linkTo(parent.start)
            }
            constrain(bodyTextView) {
                top.linkTo(titleTextView.bottom)
                start.linkTo(parent.start)
            }
            constrain(sentimentImageView) {
                top.linkTo(titleTextView.top)
                bottom.linkTo(bodyTextView.bottom)
                end.linkTo(parent.end)
                height = Dimension.fillToConstraints
            }
        }, modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()) {

            Text(
                text = title,
                fontSize = 12.sp,
                modifier = Modifier.layoutId("titleTextView")
            )
            Text(
                text = body,
                fontSize = 34.sp,
                modifier = Modifier
                    .padding(top = 4.dp)
                    .layoutId("bodyTextView"),
            )
            Image(
                painterResource(
                    id = when (sentimentLevel) {
                        0 -> R.drawable.ic_sentiment_very_satisfied_black_24dp
                        1 -> R.drawable.ic_sentiment_satisfied_black_24dp
                        else -> R.drawable.ic_sentiment_very_dissatisfied_black_24dp
                    },
                ),
                contentDescription = null,
                modifier = Modifier
                    .aspectRatio(1f)
                    .layoutId("sentimentImageView")
            )
        }
    }
}

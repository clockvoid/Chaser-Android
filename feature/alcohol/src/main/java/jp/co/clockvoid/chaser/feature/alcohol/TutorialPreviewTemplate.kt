package jp.co.clockvoid.chaser.feature.alcohol

import androidx.annotation.IntRange
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview

data class AlcoholItem(
    val title: String,
    val body: String,
    @IntRange(from = 0, to = 2)
    val sentimentLevel: Int
)

@Composable
fun TutorialPreviewTemplate(items: MutableState<List<AlcoholItem>>) {

    Column {
        TopAppBar(
            title = { Text(stringResource(id = R.string.alcohol)) },
            backgroundColor = (MaterialTheme.colors).background
        )
        LazyColumnFor(items = items.value) { item ->

            AnalyticsItem(
                title = item.title,
                body = item.body,
                sentimentLevel = item.sentimentLevel
            )
        }
    }
}

@Composable
fun AnalyticsItem(title: String, body: String, sentimentLevel: Int) {

    Card(modifier = Modifier.padding(8.dp), elevation = 4.dp) {

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
                vectorResource(id = R.drawable.ic_sentiment_satisfied_black_24dp),
                modifier = Modifier
                    .aspectRatio(1f)
                    .layoutId("sentimentImageView")
            )
        }
    }
}

@Preview
@Composable
fun TutorialPreview() {
   TutorialPreviewTemplate(mutableStateOf(listOf(AlcoholItem(
       title = "最後に吸ってから",
       body = "12時間",
       sentimentLevel = 1
   ))))
}

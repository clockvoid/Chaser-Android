package jp.co.clockvoid.chaser.feature.alcohol

import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview

@Composable
fun TutorialPreviewTemplate() {

    Column {
        TopAppBar(
            title = { Text(stringResource(id = R.string.alcohol)) },
            backgroundColor = (MaterialTheme.colors).background
        )
        LazyColumnFor(items = listOf(Triple("最後に吸ってから", "12時間", 1))) { (title, body, sentiment) ->
            AnalyticsItem(title = title, body = body, sentimentLevel = sentiment)
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
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
            }
        }, modifier = Modifier.padding(12.dp).fillMaxWidth()) {

            Text(text = title, fontSize = 12.sp, modifier = Modifier.layoutId("titleTextView"))
            Text(modifier = Modifier.padding(top = 4.dp).layoutId("bodyTextView"), text = body, fontSize = 34.sp)
            Image(vectorResource(id = R.drawable.ic_sentiment_satisfied_black_24dp), modifier = Modifier.layoutId("sentimentImageView"))
        }
    }
}

@Preview
@Composable
fun TutorialPreview() {
   TutorialPreviewTemplate()
}

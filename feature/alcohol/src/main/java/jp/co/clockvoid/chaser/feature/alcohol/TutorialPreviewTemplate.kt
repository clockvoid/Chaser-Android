package jp.co.clockvoid.chaser.feature.alcohol

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.core.tag
import androidx.ui.foundation.AdapterList
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.layout.*
import androidx.ui.material.Card
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TopAppBar
import androidx.ui.res.stringResource
import androidx.ui.res.vectorResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import androidx.ui.unit.sp

@Composable
fun TutorialPreviewTemplate() {

    Column {

        TopAppBar(
            title = { Text(stringResource(id = R.string.alcohol)) },
            backgroundColor = (MaterialTheme.colors).background
        )
        AdapterList(data = listOf(Triple("最後に吸ってから", "12時間", 1))) { (title, body, sentiment) ->
            AnalyticsItem(title = title, body = body, sentimentLevel = sentiment)
        }
    }
}

@Composable
fun AnalyticsItem(title: String, body: String, sentimentLevel: Int) {

    Card(modifier = Modifier.padding(8.dp), elevation = 4.dp) {

        ConstraintLayout(constraintSet = ConstraintSet {

            tag("titleTextView").apply {
                top constrainTo parent.top
                bottom constrainTo tag("bodyTextView").top
                left constrainTo parent.left
            }
            tag("bodyTextView").apply {
                top constrainTo tag("titleTextView").bottom
                left constrainTo parent.left
            }
            tag("sentimentImageView").apply {
                top constrainTo parent.top
                bottom constrainTo parent.bottom
                right constrainTo parent.right
            }
        }, modifier = Modifier.padding(12.dp).fillMaxWidth()) {

            Text(text = title, fontSize = 12.sp, modifier = Modifier.tag("titleTextView"))
            Text(modifier = Modifier.padding(top = 4.dp).tag("bodyTextView"), text = body, fontSize = 34.sp)
            Image(vectorResource(id = R.drawable.ic_sentiment_satisfied_black_24dp), modifier = Modifier.tag("sentimentImageView"))
        }
    }
}

@Preview
@Composable
fun TutorialPreview() {
   TutorialPreviewTemplate()
}
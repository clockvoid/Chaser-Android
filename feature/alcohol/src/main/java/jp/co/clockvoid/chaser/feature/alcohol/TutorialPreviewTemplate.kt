package jp.co.clockvoid.chaser.feature.alcohol

import androidx.annotation.IntRange
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnForIndexed
import androidx.compose.material.*
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
import com.google.android.material.composethemeadapter.MdcTheme

data class AlcoholItem(
    val title: String,
    val body: String,
    @IntRange(from = 0, to = 2)
    val sentimentLevel: Int
)

@Composable
fun HomeFloatingActionButton() {
    FloatingActionButton(
        onClick = {},
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.background,
        modifier = Modifier
            .height(48.dp)
    ) {
        ConstraintLayout(
            constraintSet = ConstraintSet {

                val text = createRefFor("text")
                val icon = createRefFor("icon")

                constrain(icon) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                }
                constrain(text) {
                    top.linkTo(parent.top)
                    start.linkTo(icon.end)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
            },
            modifier = Modifier
                .defaultMinSizeConstraints(minWidth = 200.dp)
        ) {
            Icon(
                asset = vectorResource(id = R.drawable.ic_local_bar_black_24dp),
                tint = MaterialTheme.colors.onPrimary,
                modifier = Modifier
                    .padding(start = 20.dp)
                    .layoutId("icon")
            )
            Text(
                text = "I DRANK",
                modifier = Modifier.layoutId("text")
            )
        }
    }
}

@Composable
fun AlcoholFragmentBody(items: MutableState<List<AlcoholItem>>) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.alcohol)) },
                backgroundColor = (MaterialTheme.colors).background
            )
        },
        floatingActionButton = {
            HomeFloatingActionButton()
        },
        floatingActionButtonPosition = FabPosition.Center,
    ) {
        LazyColumnForIndexed(
            items = items.value,
            contentPadding = InnerPadding(top = 8.dp)
        ) { index, item ->

            AnalyticsItem(
                title = item.title,
                body = item.body,
                sentimentLevel = item.sentimentLevel,
                isLast = items.value.size - 1 == index
            )
        }
    }
}

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
fun AlcoholFragmentPreview() {
    MdcTheme {
        AlcoholFragmentBody(mutableStateOf(listOf(AlcoholItem(
            title = "最後に吸ってから",
            body = "12時間",
            sentimentLevel = 1
        ))))
    }
}

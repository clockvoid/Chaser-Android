package jp.co.clockvoid.chaser.feature.alcohol.ui

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.InnerPadding
import androidx.compose.foundation.lazy.LazyColumnForIndexed
import androidx.compose.material.FabPosition
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import jp.co.clockvoid.chaser.feature.alcohol.R
import jp.co.clockvoid.chaser.feature.alcohol.model.AlcoholItem

@Composable
fun AlcoholFragmentBody(items: MutableState<List<AlcoholItem>>, onClickFab: () -> Unit) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.alcohol)) },
                backgroundColor = (MaterialTheme.colors).background
            )
        },
        floatingActionButton = {
            HomeFloatingActionButton(onClickFab)
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

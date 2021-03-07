package jp.co.clockvoid.chaser.feature.alcohol.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.unit.dp
import jp.co.clockvoid.chaser.feature.alcohol.model.AlcoholItem

@Composable
fun AlcoholFragmentBody(
    items: MutableState<List<AlcoholItem>>,
    onClickFab: () -> Unit,
    onClickToolbarMenu: () -> Unit
) {

    Scaffold(
        topBar = {
            Toolbar(onClickActionIcon = onClickToolbarMenu)
        },
        floatingActionButton = {
            HomeFloatingActionButton(onClickFab)
        },
        floatingActionButtonPosition = FabPosition.Center,
    ) {

        LazyColumn(
            contentPadding = PaddingValues(top = 8.dp)
        ) {

            itemsIndexed(items.value) { index, item ->

                AnalyticsItem(
                    title = item.title,
                    body = item.body,
                    sentimentLevel = item.sentimentLevel,
                    isLast = items.value.size - 1 == index
                )
            }
        }
    }
}

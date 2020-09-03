package jp.co.clockvoid.chaser.feature.alcohol.ui

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import jp.co.clockvoid.chaser.feature.alcohol.R

@Composable
fun HomeFloatingActionButton(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = { onClick() },
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

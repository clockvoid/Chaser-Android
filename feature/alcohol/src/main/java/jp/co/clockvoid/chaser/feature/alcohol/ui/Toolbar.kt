package jp.co.clockvoid.chaser.feature.alcohol.ui

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material.ripple.RippleIndication
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import jp.co.clockvoid.chaser.feature.alcohol.R

@Composable
fun Toolbar(onClickActionIcon: () -> Unit) {
    TopAppBar(
        title = { Text(stringResource(id = R.string.alcohol)) },
        backgroundColor = (MaterialTheme.colors).background,
        actions = {
            Icon(
                asset = vectorResource(R.drawable.ic_baseline_settings_24),
                tint = MaterialTheme.colors.onBackground,
                modifier = Modifier
                    .padding(end = 8.dp, start = 8.dp)
                    .fillMaxHeight()
                    .clickable(
                        indication = RippleIndication(bounded = false, radius = 20.dp)
                    ) {
                        onClickActionIcon()
                    }
            )
        }
    )
}

package jp.co.clockvoid.chaser.feature.alcohol

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.AdapterList
import androidx.ui.foundation.Text
import androidx.ui.layout.Column
import androidx.ui.layout.padding
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TopAppBar
import androidx.ui.res.stringResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp

@Composable
fun TutorialPreviewTemplate() {
    Column {
        TopAppBar(
            title = { Text(stringResource(id = R.string.alcohol)) },
            backgroundColor = (MaterialTheme.colors).background
        )
        Text(modifier = Modifier.padding(16.dp), text = "Hello, world")
        AdapterList(data = listOf(1, 2, 3)) { number ->
            Text(modifier = Modifier.padding(16.dp), text = number.toString())
        }
    }
}

@Preview
@Composable
fun TutorialPreview() {
   TutorialPreviewTemplate()
}
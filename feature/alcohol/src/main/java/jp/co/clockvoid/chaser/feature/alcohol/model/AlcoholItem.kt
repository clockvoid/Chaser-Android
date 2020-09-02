package jp.co.clockvoid.chaser.feature.alcohol.model

import androidx.annotation.IntRange

data class AlcoholItem(
    val title: String,
    val body: String,
    @IntRange(from = 0, to = 2)
    val sentimentLevel: Int
)

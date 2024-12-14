package tb.circl3t.phyphen.util

import androidx.compose.ui.geometry.Offset

const val gravity = 9.81f
const val groundThickness = 0.025f
const val surfaceThickness = 0.025f
const val standHorizontalOffset = 0.05f
const val standHeight = 0.035f
const val standWidth = 0.010f
const val ballRadius = 0.015f


val initialBallOffset = Offset(
    standHorizontalOffset,
    groundThickness + surfaceThickness + standHeight + ballRadius
)
val gridLines = listOf<Float>(
    0.05f, 0.10f, 0.15f, 0.20f, 0.25f, 0.30f, 0.35f, 0.40f, 0.45f, 0.50f,
    0.55f, 0.60f, 0.65f, 0.70f, 0.75f, 0.80f, 0.85f, 0.90f, 0.95f
)
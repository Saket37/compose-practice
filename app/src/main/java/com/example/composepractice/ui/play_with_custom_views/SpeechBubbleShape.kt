package com.example.composepractice.ui.play_with_custom_views

import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

class SpeechBubbleShape(
    private val cornerRadius: Dp = 15.dp,
    private val tipSize: Dp = 15.dp
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val tipSize = with(density) {
            tipSize.toPx()
        }
        val cornerSize = with(density) {
            cornerRadius.toPx()
        }
        val path = Path().apply {
            addRoundRect(
                RoundRect(
                    left = tipSize,
                    top = 0f,
                    bottom = size.height - tipSize,
                    right = size.width,
                    radiusX = cornerSize,
                    radiusY = cornerSize
                )
            )
            moveTo(
                x = tipSize,
                y = size.height - tipSize - cornerSize
            )
            lineTo(
                x = 0f,
                y = size.height
            )
            lineTo(
                x = tipSize + cornerSize,
                y = size.height - tipSize
            )
            close()
        }
        return Outline.Generic(path)
    }
}
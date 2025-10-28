package com.example.composepractice.ui.play_with_custom_views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RightTriangle() {
    Box(
        modifier = Modifier
            .size(200.dp)
            .drawBehind {
                val path = Path().apply {
                    moveTo(100f, 100f)
                    lineTo(200f, 200f)
                    lineTo(100f, 200f)
                    close()
                }
                drawPath(path, color = Color.Red)
            })
}

@Preview
@Composable
private fun RightTrianglePreview() {
    RightTriangle()
}

@Preview
@Composable
fun ChatBubble(modifier: Modifier = Modifier) {
    val tipSize = with(LocalDensity.current) {
        15.dp.toPx()
    }
    val cornerSize = with(LocalDensity.current) {
        15.dp.toPx()
    }
    Box(
        modifier = Modifier
            .size(200.dp)
            .drawBehind {
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
                drawPath(path, Color.Red)
            }
    )

}

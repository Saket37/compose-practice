package com.example.composepractice.ui.play_with_custom_views

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.graphics.shapes.CornerRounding
import androidx.graphics.shapes.Morph
import androidx.graphics.shapes.RoundedPolygon
import androidx.graphics.shapes.toPath

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

@Composable
fun PlayWithRectangles(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .size(200.dp)
            .drawBehind {
                val path = Path().apply {

                    RoundRect(
                        left = 0f,
                        right = size.width,
                        top = 0f,
                        bottom = size.height,
                        topLeftCornerRadius = CornerRadius(12f),
                        topRightCornerRadius = CornerRadius(12f),
                        bottomLeftCornerRadius = CornerRadius(12f),
                        bottomRightCornerRadius = CornerRadius.Zero
                    )
                }
                drawPath(path, color = Color.Red)
            })
}

@Preview
@Composable
private fun PlayWithRectanglesPreview() {
    PlayWithRectangles()
}

@Composable
fun DrawPolygonBehindText(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .drawWithCache {
                val poly = RoundedPolygon(
                    numVertices = 6,
                    radius = size.minDimension / 2,
                    centerY = size.height / 2,
                    centerX = size.width / 2,
                    rounding = CornerRounding(radius = 45f, smoothing = 0.5f)

                )
                val polyToPath = poly.toPath().asComposePath()
                onDrawBehind {
                    drawPath(polyToPath, color = Color.Black)
                }

                /*onDrawWithContent {
                    // draw behind
                    drawContent()
                    // draw after
                }*/
            }, contentAlignment = Alignment.Center
    ) {
        Text("Animation", color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
private fun InfiniteAnimPolygonPrev() {
    DrawPolygonBehindText()
}

@Composable
fun MorphPolygonWithTriangle(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .drawWithCache {
                val triangle = RoundedPolygon(
                    numVertices = 3,
                    radius = size.minDimension / 2,
                    centerX = size.width / 2,
                    centerY = size.height / 2,
                    rounding = CornerRounding(radius = 45f, smoothing = 0.5f)
                    //  increase radius for more rounded corners

                )
                val poly = RoundedPolygon(
                    numVertices = 6,
                    radius = size.minDimension / 2,
                    centerY = size.height / 2,
                    centerX = size.width / 2,
                    rounding = CornerRounding(radius = 45f, smoothing = 0.5f)

                )
                val morph = Morph(
                    start = poly,
                    end = triangle
                )
                // Here 0f means poly and 1f will be triangle
                val polyToPath = morph.toPath(0.6f).asComposePath()
                onDrawBehind {
                    drawPath(polyToPath, color = Color.Black)
                }

            }
    ) {
    }
}

@Preview(showBackground = true)
@Composable
private fun MorphPolygonWithTrianglePrev() {
    MorphPolygonWithTriangle()
}

@Composable
fun InfiniteAnimPolygonToTriangle(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition()

    /**
     * using initialValue = 0f will start the original shape
     * and targetValue = 1f will end the target original shape
     * any other value will start/end from the morph shape
     * */
    val animatedProgress by infiniteTransition.animateFloat(
        initialValue = 0.3f,
        targetValue = 0.8f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 2000,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Reverse
        )
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .drawWithCache {
                val triangle = RoundedPolygon(
                    numVertices = 3,
                    radius = size.minDimension / 2,
                    centerX = size.width / 2,
                    centerY = size.height / 2,
                    rounding = CornerRounding(radius = 45f, smoothing = 0.5f)
                    //  increase radius for more rounded corners

                )
                val poly = RoundedPolygon(
                    numVertices = 6,
                    radius = size.minDimension / 2,
                    centerY = size.height / 2,
                    centerX = size.width / 2,
                    rounding = CornerRounding(radius = 45f, smoothing = 0.5f)

                )
                val morph = Morph(
                    start = poly,
                    end = triangle
                )
                // Here 0f means poly and 1f will be triangle
                val polyToPath = morph.toPath(animatedProgress).asComposePath()
                onDrawBehind {
                    drawPath(polyToPath, color = Color.Black)
                }

            }
    ) {
    }
}

@Preview(showBackground = true)
@Composable
private fun InfiniteAnimPolygonToTrianglePrev() {
    InfiniteAnimPolygonToTriangle()
}
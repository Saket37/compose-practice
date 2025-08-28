package com.example.composepractice.ui.brush

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TestBrush(modifier: Modifier = Modifier) {
    val colorStops = arrayOf(
        0.0f to Color.Yellow,
        0.2f to Color.Red,
        1f to Color.Blue
    )
    val colorStops1 = arrayOf(
        0.0f to Color.Green,
        0.2f to Color.LightGray,
        1f to Color.Magenta
    )

    val colorStops2 = arrayOf(
        0.0f to Color(0xFF243484),
        0.2f to Color.Blue,
        1f to Color.Black
    )
    val brush = Brush.horizontalGradient(colorStops = colorStops)
    val brush1 = Brush.horizontalGradient(colorStops = colorStops1)
    val brush2 = Brush.horizontalGradient(colorStops = colorStops2)

    Box(
        modifier = Modifier
            .requiredSize(200.dp)
            .drawBehind {
                drawRect(brush = brush) // will allocate a shader to occupy the 200 x 200 dp drawing area
                inset(10f) {
                    /* Will allocate a shader to occupy the 180 x 180 dp drawing area as the
                     inset scope reduces the drawing  area by 10 pixels on the left, top, right,
                    bottom sides */
                    drawRect(brush = brush1)
                    inset(5f) {
                        /* will allocate a shader to occupy the 170 x 170 dp drawing area as the
                         inset scope reduces the  drawing area by 5 pixels on the left, top,
                         right, bottom sides */
                        drawRect(brush = brush2)
                    }
                }
            }
    )
}

@Preview
@Composable
private fun TestBrushPreview() {
    TestBrush()
}


@Composable
fun HorizontalGradient(modifier: Modifier = Modifier) {
    val sizeInPx = with(LocalDensity.current) { 200.dp.toPx() }
    val colorStops = arrayOf(
        0.2f to Color.Yellow,
        0.5f to Color.Red,
        1f to Color.Blue
    )
    val brush = Brush.linearGradient(
        colorStops = colorStops,
        start = Offset(0f, 0f),
        end = Offset(sizeInPx, 0f),
    )
    Box(
        modifier = Modifier
            .requiredSize(200.dp)
            .background(brush)
    )
}

@Preview
@Composable
private fun HorizontalGradientPreview() {
    HorizontalGradient()
}

@Composable
fun VerticalGradient(modifier: Modifier = Modifier) {
    val sizeInPx = with(LocalDensity.current) { 200.dp.toPx() }
    val colorStops = arrayOf(
        0.2f to Color.Yellow,
        0.5f to Color.Red,
        1f to Color.Blue
    )
    val brush = Brush.linearGradient(
        colorStops = colorStops,
        start = Offset(0f, 0f),
        end = Offset(0f, sizeInPx),
    )
    Box(
        modifier = Modifier
            .requiredSize(200.dp)
            .background(brush)
    )
}

@Preview
@Composable
private fun VerticalGradientPreview() {
    VerticalGradient()
}

@Composable
fun SweepGradient(modifier: Modifier = Modifier) {
    val sizeInPx = with(LocalDensity.current) { 200.dp.toPx() }
    val colorStops = arrayOf(
        0.2f to Color.Yellow,
        0.5f to Color.Red,
        1f to Color.Blue
    )
    val brush = Brush.sweepGradient(
        colorStops = colorStops
    )
    Box(
        modifier = Modifier
            .requiredSize(200.dp)
            .background(brush)
    )
}

@Preview
@Composable
private fun SweepGradientPreview() {
    SweepGradient()
}

@Composable
fun RadialGradient(modifier: Modifier = Modifier) {
    val sizeInPx = with(LocalDensity.current) { 200.dp.toPx() }
    val colorStops = arrayOf(
        0.2f to Color.Yellow,
        0.5f to Color.Red,
        1f to Color.Blue
    )
    val brush = Brush.radialGradient(
        colorStops = colorStops,

        )
    Box(
        modifier = Modifier
            .requiredSize(200.dp)
            .background(brush)
    )
}

@Preview
@Composable
private fun RadialGradientPreview() {
    RadialGradient()
}

@Composable
fun Solid(modifier: Modifier = Modifier) {
    val sizeInPx = with(LocalDensity.current) { 200.dp.toPx() }
    val colorStops = arrayOf(
        0.2f to Color.Yellow,
        0.5f to Color.Red,
        1f to Color.Blue
    )

    val brush = Brush.radialGradient(
        colorStops = colorStops,

        )
    Box(
        modifier = Modifier
            .requiredSize(200.dp)
            .background(Color.Green)
    )
}

@Preview
@Composable
private fun SolidPreview() {
    Solid()
}
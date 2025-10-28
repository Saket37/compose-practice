package com.example.composepractice.ui.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
private fun Lines() {

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        val height = size.height
        val width = size.width

        // horizontal - mid line
        drawLine(
            color = Color.Black,
            start = Offset(x = 20f, y = height / 2),
            end = Offset(x = width - 20f, y = height / 2),
            strokeWidth = 10.dp.toPx(),
            cap = StrokeCap.Butt
        )

        // vertical-mid line
        drawLine(
            color = Color.Black,
            start = Offset(x = width / 2, y = 0f),
            end = Offset(x = width / 2, y = height),
            strokeWidth = 2.dp.toPx(),
            cap = StrokeCap.Butt
        )

        // dashed lines
        drawLine(
            color = Color.Black,
            start = Offset(x = 40f, y = 100f),
            end = Offset(x = width - 40f, y = 100f),
            strokeWidth = 2.dp.toPx(),
            cap = StrokeCap.Round,
            pathEffect = PathEffect.dashPathEffect(intervals = floatArrayOf(10f, 20f), phase = 0f)
        )

        //circle dashed lines
        drawLine(
            color = Color.Black,
            start = Offset(x = 40f, y = 150f),
            end = Offset(x = width - 40f, y = 150f),
            strokeWidth = 10.dp.toPx(),
            cap = StrokeCap.Round,
            pathEffect = PathEffect.dashPathEffect(intervals = floatArrayOf(0f, 40f), phase = 20f)
        )


        //  lines
        drawLine(
            color = Color.Black,
            start = Offset(x = 40f, y = 250f),
            end = Offset(x = width - 40f, y = 250f),
            strokeWidth = 20.dp.toPx(),
            cap = StrokeCap.Round,
            pathEffect = PathEffect.cornerPathEffect(10f)
        )

    }

}

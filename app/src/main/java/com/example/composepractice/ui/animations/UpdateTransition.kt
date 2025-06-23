package com.example.composepractice.ui.animations

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private enum class BoxState {
    Small,
    Large
}

@Preview(showBackground = true)
@Composable
fun UpdateTransition(modifier: Modifier = Modifier) {
    var boxState by remember { mutableStateOf(BoxState.Small) }
    val color = when (boxState) {
        BoxState.Small -> Color.Blue
        BoxState.Large -> Color.Yellow
    }
    val size = when (boxState) {
        BoxState.Small -> 100.dp
        BoxState.Large -> 200.dp
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = {
            boxState = when (boxState) {
                BoxState.Small -> BoxState.Large
                BoxState.Large -> BoxState.Small
            }
        }) {
            Text(text = "Change Color and Size")
        }

        Box(
            modifier = Modifier
                .size(size)
                .background(color)
        )
    }
}


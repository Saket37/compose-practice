package com.example.composepractice.ui.animations

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun SharedTransition() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // This Box is a DIRECT child of the Row, so weight works.
        Box(
            modifier = Modifier
                .weight(1f) // Takes up all available space
                .height(50.dp)
                .background(Color.Blue)
        ) {
            Text("Weighted Item", color = Color.White, modifier = Modifier.align(Alignment.Center))
        }

        Box(
            modifier = Modifier
                .width(100.dp)
                .height(50.dp)
                .background(Color.Green)
        ) {
            Text("Fixed Item", color = Color.White, modifier = Modifier.align(Alignment.Center))
        }
    }
}
@OptIn(ExperimentalSharedTransitionApi::class)
@Preview
@Composable
fun BrokenRowLayout() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // We wrap the weighted item in a SharedTransitionLayout.
        // This layout is now the DIRECT child of the Row.
        SharedTransitionLayout(
            modifier = Modifier
                .weight(1f) // The weight is now applied to the layout, not the Box!
        ) {
            Box(
                modifier = Modifier
                    // This Box is no longer a direct child of the Row.
                    .height(50.dp)
                    .background(Color.Red)
                    .weight(1f)
            ) {
                Text("Broken Item", color = Color.White, modifier = Modifier.align(Alignment.Center))
            }
        }

        Box(
            modifier = Modifier
                .width(100.dp)
                .height(50.dp)
                .background(Color.Green)
        ) {
            Text("Fixed Item", color = Color.White, modifier = Modifier.align(Alignment.Center))
        }
    }
}

//@OptIn(ExperimentalSharedTransitionApi::class)
//@Preview
//@Composable
//fun FixedWithScopeLayout() {
//    Row(
//        modifier = Modifier.fillMaxWidth(),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        // We use the SharedTransitionScope composable.
//        // It's invisible to the layout system.
//        SharedTransitionScope {
//            // The Row still sees this Box as its DIRECT child.
//            // The `weight` modifier works correctly again!
//            Box(
//                modifier = Modifier
//                    .weight(1f)
//                    .height(50.dp)
//                    .background(Color.Blue)
//            ) {
//                // And this Box can still use the scope for animations,
//                // for example, with Modifier.sharedElement().
//                Text("Fixed Item", color = Color.White, modifier = Modifier.align(Alignment.Center))
//            }
//        }
//
//        Box(
//            modifier = Modifier
//                .width(100.dp)
//                .height(50.dp)
//                .background(Color.Green)
//        ) {
//            Text("Fixed Item", color = Color.White, modifier = Modifier.align(Alignment.Center))
//        }
//    }
//}
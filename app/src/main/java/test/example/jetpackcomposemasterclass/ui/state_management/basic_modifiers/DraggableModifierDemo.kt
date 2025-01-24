@file:OptIn(ExperimentalFoundationApi::class)

package test.example.jetpackcomposemasterclass.ui.state_management.basic_modifiers

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.draggable2D
import androidx.compose.foundation.gestures.rememberDraggable2DState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.round
import test.example.jetpackcomposemasterclass.ui.theme.JetpackComposeMasterclassTheme

@Composable
fun DraggableModifierDemo(modifier: Modifier = Modifier) {

  var offset by remember {
    mutableStateOf(Offset.Zero)
  }

  Box(
    modifier = modifier
      .fillMaxSize()
      .background(Color.White),
    contentAlignment = Alignment.Center
  ) {
    Box(
      modifier = Modifier
        .size(100.dp)
        .offset {
          offset.round()
        }
        .draggable2D(
          state = rememberDraggable2DState {
            offset += it
          }
        )
        .clip(CircleShape)
        .background(Color.Red)

    )
  }
}

@Preview(
  showBackground = true
)
@Composable
fun DraggableModifierDemoPreview() {
  JetpackComposeMasterclassTheme {
    DraggableModifierDemo()
  }
}
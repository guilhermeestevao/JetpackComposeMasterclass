package test.example.jetpackcomposemasterclass.ui.state_management.basic_modifiers

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import test.example.jetpackcomposemasterclass.ui.theme.JetpackComposeMasterclassTheme

@Composable
fun ClickableModifierDemo(modifier: Modifier = Modifier) {
  val interactionSource = remember {
    MutableInteractionSource()
  }
  val isPressed by interactionSource.collectIsPressedAsState()

  Box(
    modifier = modifier
      .size(100.dp)
      .background(
        if(isPressed) Color.Blue else Color.White)
      .clickable(
        interactionSource,
        LocalIndication.current,
        enabled = true
      ) {
        println("Hello world")
      }
      .padding(16.dp),

    contentAlignment = Alignment.Center
  ) {
    Text("Hello world")
  }
}

@Preview(
  showBackground = true
)
@Composable
fun ClickableModifierDemoPreview() {
  JetpackComposeMasterclassTheme {
    ClickableModifierDemo()
  }
}
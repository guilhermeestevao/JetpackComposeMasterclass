package test.example.jetpackcomposemasterclass.ui.basic_layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import test.example.jetpackcomposemasterclass.ui.theme.JetpackComposeMasterclassTheme

@Composable
fun RowColumnDemo(modifier: Modifier = Modifier) {
  Row(
    modifier = modifier.fillMaxSize(),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween
  ) {
    Box(
      modifier = Modifier
        .size(100.dp)
        .background(Color.Red)
    )
    Box(
      modifier = Modifier
        .size(100.dp)
        .background(Color.Blue)
        .align(Alignment.Top)
    )
    Box(
      modifier = Modifier
        .size(100.dp)
        .background(Color.Green)
    )
  }
}

@Preview(
  backgroundColor = 0xfff,
  showBackground = true
)
@Composable
fun RowColumnDemoPreview() {
  JetpackComposeMasterclassTheme {
    RowColumnDemo()
  }
}
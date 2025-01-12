package test.example.jetpackcomposemasterclass.ui.state_management

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import test.example.jetpackcomposemasterclass.ui.theme.JetpackComposeMasterclassTheme


@Composable
fun Counter(
  counter: Int,
  onCounterButtonClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  Box(
    modifier = modifier,
    contentAlignment = Alignment.Center
  ) {
    Button(
      onClick = onCounterButtonClick
    ) {
      Text("Counter: $counter")
    }
  }
}

@Preview(
  showBackground = true
)
@Composable
fun CounterPreview() {
  JetpackComposeMasterclassTheme {
    Counter(
      counter = 0,
      onCounterButtonClick = {}
    )
  }
}
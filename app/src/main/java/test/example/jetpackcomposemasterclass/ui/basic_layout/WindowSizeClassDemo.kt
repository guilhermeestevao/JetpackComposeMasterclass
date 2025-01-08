package test.example.jetpackcomposemasterclass.ui.basic_layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowWidthSizeClass
import test.example.jetpackcomposemasterclass.ui.theme.JetpackComposeMasterclassTheme

@Composable
fun WindowSizeClassDemo(modifier: Modifier = Modifier) {
  val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass

  Scaffold { padding ->
    Box(
      modifier = Modifier
      .fillMaxSize()
      .padding(padding)
    ) {
      when(windowSizeClass.windowWidthSizeClass) {
        WindowWidthSizeClass.COMPACT -> {
          MyLazyList()
        }
        WindowWidthSizeClass.MEDIUM -> {
          Text("Midium")
        }
        WindowWidthSizeClass.EXPANDED -> {
          Row(
            modifier = Modifier.fillMaxSize()
          ){
            Column(
              modifier = Modifier
                .fillMaxHeight()
                .weight(3f)
                .background(Color.Red)
            ) {
              Text("Option 1")
              Text("Option 2")
              Text("Option 3")
            }
            MyLazyList(
              modifier = Modifier
                .fillMaxHeight()
                .weight(7f)
            )
          }
        }
      }
    }
  }
}

@Composable
fun MyLazyList(modifier: Modifier = Modifier) {
  LazyColumn(
    modifier = modifier.fillMaxSize()
  ) {
    items(40) {
      Text(
        "Item $it",
        modifier = Modifier.padding(16.dp)
      )
    }
  }
}

@PreviewScreenSizes
@Preview(
  showBackground = true
)
@Composable
fun WindowSizeClassDemoPreview() {
  JetpackComposeMasterclassTheme {
    WindowSizeClassDemo()
  }
}
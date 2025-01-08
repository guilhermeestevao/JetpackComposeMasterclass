@file:OptIn(ExperimentalFoundationApi::class)

package test.example.jetpackcomposemasterclass.ui.basic_layout

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import test.example.jetpackcomposemasterclass.ui.theme.JetpackComposeMasterclassTheme

@Composable
fun LazyListDemo(modifier: Modifier = Modifier) {
  LazyColumn(
    modifier = Modifier.fillMaxSize(),
    contentPadding = PaddingValues(16.dp),
    verticalArrangement = Arrangement.spacedBy(16.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    stickyHeader {
      Text(
        text = "Stickheader from 0 to 99!",
        modifier = Modifier.fillMaxWidth()
          .background(Color.Green)
      )
    }
    items(100) {
        Text("Item $it")
    }
    stickyHeader {
      Text(
        text = "Stickheader from 100 to 199!",
        modifier = Modifier.fillMaxWidth()
          .background(Color.Green)
      )
    }
    items(100) {
      Text("Item ${it+100}")
    }
    item {
      Text(
        "Reached the end!",
        modifier = Modifier
          .fillMaxWidth()
          .background(Color.Red)
      )
    }
  }
}

@Preview(
  showBackground = true
)
@Composable
fun LazyListDemoPreview() {
  JetpackComposeMasterclassTheme {
    LazyListDemo()
  }
}
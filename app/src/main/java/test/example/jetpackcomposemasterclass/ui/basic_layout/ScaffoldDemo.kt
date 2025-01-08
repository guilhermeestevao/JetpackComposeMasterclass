@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package test.example.jetpackcomposemasterclass.ui.basic_layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch
import test.example.jetpackcomposemasterclass.ui.theme.JetpackComposeMasterclassTheme

@Composable
fun ScaffoldDemo(modifier: Modifier = Modifier) {
  val snackbarState = remember {
    SnackbarHostState()
  }
  val scope = rememberCoroutineScope()
  Scaffold(
    topBar = {
      TopAppBar(
        title = { Text("Hello world!") },
        navigationIcon = {
          IconButton(onClick = {}) {
            Icon(
              imageVector = Icons.AutoMirrored.Default.ArrowBack,
              contentDescription = "Go back"
            )
          }
        }
      )
    },
    floatingActionButton = {
      FloatingActionButton(
        onClick = {
          scope.launch {
            snackbarState.showSnackbar("Clicked FAB")
          }
        }
      ) {
        Icon(
          imageVector = Icons.Default.Add,
          contentDescription = "add"
        )
      }
    },
    snackbarHost = {
      SnackbarHost(snackbarState)
    },
    bottomBar = {
      BottomAppBar {
        NavigationBarItem(
          selected = true,
          onClick = {},
          icon = {
            Icon(
              imageVector = Icons.Default.Star,
              contentDescription = null
            )
          },
          label = {
            Text("Favorites")
          }
        )
        NavigationBarItem(
          selected = false,
          onClick = {},
          icon = {
            Icon(
              imageVector = Icons.Default.Search,
              contentDescription = null
            )
          },
          label = {
            Text("Search")
          }
        )
      }
    }
  ) { padding ->
    Box(
      modifier = Modifier
        .fillMaxSize()
        .padding(padding)
        .background(Color.Red)
    ) {
      Text("Hello World!")
    }
  }
}

@Preview(
  showBackground = true
)
@Composable
fun ScaffoldDemoPreview() {
  JetpackComposeMasterclassTheme {
    ScaffoldDemo()
  }
}
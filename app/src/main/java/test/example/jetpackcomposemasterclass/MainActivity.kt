package test.example.jetpackcomposemasterclass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import test.example.jetpackcomposemasterclass.ui.state_management.basic_modifiers.FocusManagerModifierDemo
import test.example.jetpackcomposemasterclass.ui.theme.JetpackComposeMasterclassTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      JetpackComposeMasterclassTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
          FocusManagerModifierDemo(modifier = Modifier.padding(padding))
          /*TodoListScreenRoot(
            modifier = Modifier.padding(innerPadding)
          )*/
        }
      }
    }
  }
}


@Composable
fun Greeting(modifier: Modifier = Modifier) {
  LazyColumn(
    modifier = modifier
      .fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.SpaceEvenly
  ) {
    item {
      Button(
        onClick = {

        }
      ) {
        Text("Number Guess")
      }
    }
    item {
      Button(
        onClick = {

        }
      ) {
        Text("Todo List")
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  JetpackComposeMasterclassTheme {
    Greeting()
  }
}
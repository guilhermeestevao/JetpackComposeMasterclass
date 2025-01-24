package test.example.jetpackcomposemasterclass.ui.state_management.basic_modifiers

import androidx.compose.foundation.border
import androidx.compose.foundation.focusGroup
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import test.example.jetpackcomposemasterclass.ui.theme.JetpackComposeMasterclassTheme

@Composable
fun FocusManagerModifierDemo(modifier: Modifier = Modifier) {
  val focusRequester = remember {
    FocusRequester()
  }
  val focusManager = LocalFocusManager.current
  Column(
    modifier = modifier
      .fillMaxSize(),
    verticalArrangement = Arrangement.spacedBy(16.dp)
  ) {
    TextField(
      value = "",
      onValueChange = {},
      modifier = Modifier
        .focusRequester(focusRequester),
      keyboardActions = KeyboardActions(
        onNext = {
          focusManager.moveFocus(FocusDirection.Down)
        }
      ),
      keyboardOptions = KeyboardOptions(
        imeAction = ImeAction.Next
      )
    )
    var isFocused by remember {
      mutableStateOf(false)
    }
    Column (
      modifier = Modifier
        .fillMaxWidth()
        .border(
          width = 5.dp,
          color = if(isFocused) Color.Red else Color.Gray
        )
        .onFocusChanged {
          isFocused = it.hasFocus
        }
        .focusGroup()
        .padding(16.dp),
      verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
      TextField(
        value = "",
        onValueChange = {},
        keyboardActions = KeyboardActions(
          onNext = {
            focusManager.moveFocus(FocusDirection.Down)
          }
        ),
        keyboardOptions = KeyboardOptions(
          imeAction = ImeAction.Next
        )
      )
      TextField(
        value = "",
        onValueChange = {},
        keyboardActions = KeyboardActions(
          onNext = {
            focusManager.moveFocus(FocusDirection.Down)
          }
        ),
        keyboardOptions = KeyboardOptions(
          imeAction = ImeAction.Next
        )
      )
    }
    TextField(
      value = "",
      onValueChange = {},
      keyboardActions = KeyboardActions(
        onNext = {
          focusManager.moveFocus(FocusDirection.Down)
        }
      ),
      keyboardOptions = KeyboardOptions(
        imeAction = ImeAction.Next
      )
    )
    TextField(
      value = "",
      onValueChange = {}
    )
    Button(
      onClick = {
        focusRequester.requestFocus()
      }
    ) {
      Text("Start filling out form")
    }

    Button(
      onClick = {
        focusManager.clearFocus()
      }
    ) {
      Text("Clear focus")
    }
  }
}

@Preview(
  showBackground = true
)
@Composable
fun FocusManagerModifierDemoPreview(modifier: Modifier = Modifier) {
  JetpackComposeMasterclassTheme {
    FocusManagerModifierDemo()
  }
}


package test.example.jetpackcomposemasterclass.ui.state_management.number_guess

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import test.example.jetpackcomposemasterclass.ui.theme.JetpackComposeMasterclassTheme

@Composable
fun NumberGuessScreenRoot(modifier: Modifier = Modifier) {
  val viewmodel = viewModel<NumberGuessViewModel>()
  val state by viewmodel.state.collectAsStateWithLifecycle()
  NumberGuessScreen(
    state = state,
    onAction = viewmodel::onAction,
    modifier = modifier
  )
}

@Composable
fun NumberGuessScreen(
  state: NumberGuessState,
  onAction: (NumberGuessAction) -> Unit,
  modifier: Modifier = Modifier
) {
  Column(
    modifier = modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
  ) {
    TextField(
      value = state.numberText,
      onValueChange = { newText ->
        onAction(NumberGuessAction.OnNumberTextChange(newText))
      },
      keyboardOptions =  KeyboardOptions(
        keyboardType = KeyboardType.Number
      )
    )
    Button(
      onClick = { onAction(NumberGuessAction.OnGuessCkick) }
    ) {
      Text("Make guess")
    }
    if(state.guessText != null) {
      Text(text = state.guessText)
    }
    if(state.isGuessCorrect){
      Button(
        onClick = {
          onAction(NumberGuessAction.OnStartNewGame)
        }
      ) {
        Text("New game")
      }
    }
  }

}

@Preview(
  showBackground = true
)
@Composable
fun NumberGuessScreenPreview() {
  JetpackComposeMasterclassTheme {
    NumberGuessScreen(NumberGuessState(), onAction = {})
  }
}
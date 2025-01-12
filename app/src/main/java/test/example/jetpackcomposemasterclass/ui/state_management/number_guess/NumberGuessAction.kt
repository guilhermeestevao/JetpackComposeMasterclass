package test.example.jetpackcomposemasterclass.ui.state_management.number_guess

sealed interface NumberGuessAction {
  data object OnGuessCkick: NumberGuessAction
  data class OnNumberTextChange(val numberText: String): NumberGuessAction
  data object OnStartNewGame: NumberGuessAction
}
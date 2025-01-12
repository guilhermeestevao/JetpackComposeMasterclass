package test.example.jetpackcomposemasterclass.ui.state_management.number_guess

data class NumberGuessState(
  val numberText: String = "",
  val guessText: String? = "",
  val isGuessCorrect: Boolean = false
)

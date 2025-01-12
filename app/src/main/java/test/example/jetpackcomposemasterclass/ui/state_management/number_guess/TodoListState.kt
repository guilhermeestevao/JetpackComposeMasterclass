package test.example.jetpackcomposemasterclass.ui.state_management.number_guess

import test.example.jetpackcomposemasterclass.ui.state_management.todo_list.Todo

data class TodoListState(
  val todos: List<Todo> = (1..10).map {
    Todo(
      title = "Title todo $it",
      description = "Description todo $it",
      isChecked = false
    )
  },
  val title: String = "",
  val description: String = "",
)

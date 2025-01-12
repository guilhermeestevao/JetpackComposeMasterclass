package test.example.jetpackcomposemasterclass.ui.state_management.todo_list

sealed interface TodoListActions {
  data object OnAddNewItem: TodoListActions
  data class OnCheckItem(val todo: Todo): TodoListActions
  data class OnDeleteItem(val todo: Todo): TodoListActions
  data class OnChangeTitle(val title: String): TodoListActions
  data class OnChangeDescription(val description: String): TodoListActions
}
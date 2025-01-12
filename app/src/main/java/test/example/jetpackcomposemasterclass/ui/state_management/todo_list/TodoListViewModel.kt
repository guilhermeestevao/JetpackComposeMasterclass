package test.example.jetpackcomposemasterclass.ui.state_management.todo_list

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import test.example.jetpackcomposemasterclass.ui.state_management.number_guess.TodoListState

class TodoListViewModel: ViewModel() {

  private val _state = MutableStateFlow(TodoListState())
  val state = _state.asStateFlow()

  fun onAction(action: TodoListActions) {
    when(action) {
      is TodoListActions.OnAddNewItem -> {
        if(_state.value.title.isNotEmpty()) {
          val newItem = Todo(
            title = _state.value.title,
            description = _state.value.description,
            isChecked = false
          )
          _state.update {
            it.copy(
              todos = it.todos + newItem,
              title = "",
              description = ""
            )
          }
        }
      }
      is TodoListActions.OnCheckItem -> {
        _state.update { it.copy(
          todos = it.todos.map {
            if(it == action.todo) {
              it.copy(
                isChecked = !it.isChecked
              )
            } else it
          }
        ) }
      }
      is TodoListActions.OnDeleteItem -> {
        _state.update { it.copy(
          todos = it.todos.filter { it != action.todo }
        )}
      }

      is TodoListActions.OnChangeDescription -> {
        _state.update { it.copy(description = action.description) }
      }
      is TodoListActions.OnChangeTitle -> {
        _state.update { it.copy(title = action.title) }
      }
    }
  }
}
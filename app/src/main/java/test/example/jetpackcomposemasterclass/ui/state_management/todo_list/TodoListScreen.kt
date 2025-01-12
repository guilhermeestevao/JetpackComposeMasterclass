package test.example.jetpackcomposemasterclass.ui.state_management.todo_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import test.example.jetpackcomposemasterclass.ui.state_management.number_guess.TodoListState
import test.example.jetpackcomposemasterclass.ui.theme.JetpackComposeMasterclassTheme

@Composable
fun TodoListScreenRoot(
  modifier: Modifier = Modifier,
) {
  val viewModel = viewModel<TodoListViewModel>()
  val state by viewModel.state.collectAsStateWithLifecycle()
  TodoListScreen(
    modifier = modifier,
    state = state,
    action = viewModel::onAction
  )
}

@Composable
fun TodoListScreen(
  modifier: Modifier = Modifier,
  state: TodoListState,
  action: (TodoListActions) -> Unit
) {
  Column(
    modifier = modifier
      .fillMaxSize()
  ) {
    LazyColumn(
      modifier = Modifier.weight(1f)
    ){
      items(state.todos){ item ->
        TodoItem(
          todoItem = item,
          onItemCheckedClick = {
            action(TodoListActions.OnCheckItem(item))
          },
          onItemDeletedClick = {
            action(TodoListActions.OnDeleteItem(item))
          }
        )
      }
    }
    HorizontalDivider()
    NewTodoItemForm(
      modifier = Modifier.fillMaxWidth(),
      title = state.title,
      description = state.description,
      onChangeTitle = {
        action(TodoListActions.OnChangeTitle(it))
      },
      onChangeDescription = {
        action(TodoListActions.OnChangeDescription(it))
      },
      addItemButtonClick = {
        action(TodoListActions.OnAddNewItem)
      }
    )
  }
}

@Composable
fun NewTodoItemForm(
  modifier: Modifier = Modifier,
  title: String,
  description: String,
  addItemButtonClick: () -> Unit,
  onChangeTitle: (String) -> Unit,
  onChangeDescription: (String) -> Unit
){

  Row(
    modifier = modifier.padding(16.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(8.dp)
  ){
    Column(
      modifier = Modifier.weight(1f),
      verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      TextField(
        value = title,
        onValueChange = onChangeTitle,
        placeholder = {
          Text("title")
        },
        modifier = Modifier.fillMaxWidth()
      )
      TextField(
        value = description,
        onValueChange = onChangeDescription,
        placeholder = {
          Text("description")
        },
        modifier = Modifier.fillMaxWidth()
      )
    }
    Button(
      onClick = addItemButtonClick
    ) {
      Text(text ="Add")
    }
  }
}

@Preview(
  showBackground = true
)
@Composable
fun TodoListScreenPreview(modifier: Modifier = Modifier) {
  JetpackComposeMasterclassTheme {
    TodoListScreen(
      state = TodoListState(),
      action = {}
    )
  }
}

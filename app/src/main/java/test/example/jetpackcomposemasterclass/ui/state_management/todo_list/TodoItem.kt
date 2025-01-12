package test.example.jetpackcomposemasterclass.ui.state_management.todo_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import test.example.jetpackcomposemasterclass.ui.theme.JetpackComposeMasterclassTheme

@Composable
fun TodoItem(
  modifier: Modifier = Modifier,
  todoItem: Todo,
  onItemCheckedClick: (isChecked: Boolean) -> Unit,
  onItemDeletedClick: () -> Unit
) {

  Row(
    modifier = modifier.padding(16.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    Column(
      modifier = Modifier.weight(1f)
    ) {
      val textDecoration = if (todoItem.isChecked){
        TextDecoration.LineThrough
      } else {
        TextDecoration.None
      }

      Text(
        text = todoItem.title,
        fontWeight = FontWeight.SemiBold,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
        textDecoration = textDecoration
      )
      Text(
        text = todoItem.description,
        maxLines = 3,
        overflow = TextOverflow.Ellipsis,
        textDecoration = textDecoration
      )
    }
    Checkbox(
      checked = todoItem.isChecked,
      onCheckedChange = onItemCheckedClick
    )
    IconButton(
      onClick = onItemDeletedClick
    ) {
      Icon(
        imageVector = Icons.Default.Delete,
        contentDescription = "Delete"
      )
    }

  }

}

@Preview(
  showBackground = true
)
@Composable
fun TodoItemPreview() {
  JetpackComposeMasterclassTheme {
    TodoItem(
      todoItem = Todo(
        isChecked = false,
        title = "Bring oput the trash",
        description = "Better do this berofer wife comes home"
      ),
      onItemCheckedClick = {},
      onItemDeletedClick = {}
    )
  }
}


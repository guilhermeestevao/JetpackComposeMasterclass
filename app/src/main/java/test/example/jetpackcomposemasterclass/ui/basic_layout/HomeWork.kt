package test.example.jetpackcomposemasterclass.ui.basic_layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.sharp.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import test.example.jetpackcomposemasterclass.ui.theme.JetpackComposeMasterclassTheme

@Composable
fun HomeWork(
  modifier: Modifier = Modifier,
  title: String,
  content: String,
  date: String
) {
  Column(
    modifier = modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(8.dp))
      .background(Color(245, 129, 98))
      .padding(16.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp)
  ){
    Row{
      Icon(
        imageVector = Icons.Outlined.CheckCircle,
        contentDescription = null,
        tint = Color.White,
      )
      Column(
        horizontalAlignment = Alignment.End
      ){
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween
        ) {
          Text(
            text = title,
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
              .padding(horizontal = 8.dp)
              .weight(1f)
          )
          Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = null,
            tint = Color.White
          )
        }
        Text(
          text = content,
          color = Color.White,
          modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 8.dp),
        )
        Text(
          text = date,
          color = Color.White,
        )
      }
    }

  }
}

@Preview(
  showBackground = true
)
@Composable
fun HomeWorkPreview() {
  JetpackComposeMasterclassTheme {
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
      verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      HomeWork(
        title = "Project X",
        content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
        date = "Mar 5, 10:00"
      )
      HomeWork(
        title = "Project X",
        content = "This is a shot text",
        date = "Mar 5, 10:00"
      )
    }

  }
}
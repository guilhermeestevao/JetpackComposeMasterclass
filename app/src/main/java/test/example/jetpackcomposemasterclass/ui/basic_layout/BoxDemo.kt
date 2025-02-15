package test.example.jetpackcomposemasterclass.ui.basic_layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import test.example.jetpackcomposemasterclass.R
import test.example.jetpackcomposemasterclass.ui.theme.JetpackComposeMasterclassTheme

@Composable
fun BoxDemo(modifier: Modifier = Modifier) {
  Box(
    modifier = modifier,
    contentAlignment = Alignment.Center
  ) {
    Image(
      painter = painterResource(R.drawable.kermit),
      contentDescription = null
    )
    Box(
      modifier = Modifier
        .matchParentSize()
        .background(
          brush = Brush.verticalGradient(
            colors = listOf(Color.Transparent, Color.Black)
          )
        )
    )
    IconButton(
      onClick = {},
      modifier = Modifier.align(Alignment.BottomEnd)
    ){
      Icon(
        imageVector = Icons.Default.Star,
        contentDescription = null,
        tint = Color.Yellow
      )
    }
  }
}

@Preview(
  showBackground = true
)
@Composable
fun BoxDemoPreview() {
  JetpackComposeMasterclassTheme {
    BoxDemo()
  }
}

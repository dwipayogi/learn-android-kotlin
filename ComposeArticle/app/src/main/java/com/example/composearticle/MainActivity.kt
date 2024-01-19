package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArticleImage(stringResource(R.string.title), stringResource(R.string.definition), stringResource(R.string.desc))
                }
            }
        }
    }
}

@Composable
fun ArticleText(title: String, definition: String , desc: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = modifier.padding(16.dp)
        )
        Text(
            text = definition,
            textAlign = TextAlign.Justify,
            modifier = modifier.padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = desc,
            textAlign = TextAlign.Justify,
            modifier = modifier.padding(16.dp)
        )
    }
}

@Composable
fun ArticleImage(title: String, definition: String , desc: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.bg_compose_background)
    Column {
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier
        )
        ArticleText(title, definition, desc, modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeArticleTheme {
        ArticleImage(stringResource(R.string.title), stringResource(R.string.definition), stringResource(R.string.desc))
    }
}
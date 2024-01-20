package com.example.mybusinesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mybusinesscard.ui.theme.MyBusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyBusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CardApp(modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFF6EDFF))
                    )
                }
            }
        }
    }
}

@Composable
fun HeroSection(name: String, title: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable._692106119646)
    Column(
        modifier = Modifier
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.width(160.dp)
        )
        Text(
            text = name,
            fontSize = 32.sp,
            modifier = modifier.padding(16.dp)
        )
        Text(
            text = title,
            fontSize = 16.sp,
            modifier = modifier.padding(bottom = 16.dp)
        )
    }
}

@Composable
fun FooterSection(number: String, name: String, email: String) {
    Column(
        modifier = Modifier
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row {
            Icon(
                Icons.Rounded.Phone,
                contentDescription = "phone",
                modifier = Modifier.padding(end = 12.dp)
            )
            Text(
                text = number,
                fontSize = 16.sp
            )
        }
        Row {
            Icon(
                Icons.Rounded.Share,
                contentDescription = "share",
                modifier = Modifier.padding(end = 12.dp)
            )
            Text(
                text = name,
                fontSize = 16.sp,
            )
        }
        Row {
            Icon(
                Icons.Rounded.Email,
                contentDescription = "email",
                modifier = Modifier.padding(end = 12.dp)
            )
            Text(
                text = email,
                fontSize = 16.sp,
            )
        }
    }
}

@Composable
fun CardApp(modifier: Modifier) {
    Column(
        modifier = modifier
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        HeroSection(name = "Dwipa Yogiswara", title = "Android Developer")
        FooterSection(number = "+62 82135472872", name = "@dwipayogi", email = "dwipayogi50@gmail.com")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyBusinessCardTheme {
        CardApp(modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6EDFF))
        )
    }
}
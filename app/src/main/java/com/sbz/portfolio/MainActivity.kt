package com.sbz.portfolio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sbz.portfolio.data.ProjectList
import com.sbz.portfolio.data.Projects
import com.sbz.portfolio.ui.theme.PortFolioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PortFolioTheme {
                Surface(
                    color = Color.White
                ) {
                    Portfolio()
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    PortFolioTheme {
        Portfolio()
    }
}

@Composable
fun Portfolio() {

    val isOpen = remember {
        mutableStateOf(false)
    }


    Surface(
        shadowElevation = 8.dp,
        shape = RoundedCornerShape(12.dp),
        color = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.user),
                contentDescription = "User Icon",
                modifier = Modifier
                    .size(60.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Divider()
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Shabaj Ansari",
                style = TextStyle(
                    color = Color.Blue,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Text(
                text = "Android Developer",
                style = MaterialTheme.typography.bodyMedium

            )

            SocialMediaInfo(
                text = "/shabaj_ansari_05",
                image = painterResource(id = R.drawable.instagram),
                modifier = Modifier.padding(10.dp)
            )
            SocialMediaInfo(
                text = "/SHabaj-dev",
                image = painterResource(
                    id = R.drawable.github
                )
            )

            Button(
                onClick = { isOpen.value = !isOpen.value },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "My Projects")
            }

            if (isOpen.value) {
                LazyColumn {
                    items(ProjectList().getProjectsList()) { item ->
                        ProjectItem(item)

                    }
                }
            }
        }
    }
}

@Composable
fun ProjectItem(item: Projects) {

    Row(modifier = Modifier.padding(5.dp)) {
        Image(
            painter = painterResource(id = R.drawable.user),
            contentDescription = item.projectName,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        )

        Column(
            modifier = Modifier
                .padding(5.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = item.projectName,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Blue
                )
            )

            Text(
                text = item.projectDescription,
                style = TextStyle(
                    fontSize = 12.sp,
                    color = Color.LightGray
                )
            )
        }

    }

}

@Composable
fun SocialMediaInfo(
    text: String,
    image: Painter,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.size(20.dp)
        )

        Text(
            text = text,
            style = MaterialTheme.typography.bodySmall
        )
    }
}
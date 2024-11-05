package com.example.myapplication.ui.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myapplication.R
import com.example.myapplication.core.utils.fontDimensionResource
import com.example.myapplication.ui.main.BottomNavigationBar
import com.example.myapplication.ui.main.items
import com.example.myapplication.ui.theme.primaryLight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(
                    "Home",
                    fontSize = fontDimensionResource(id = com.intuit.ssp.R.dimen._15ssp),
                    fontWeight = FontWeight.Bold,
                    color = primaryLight
                ) },
                actions = {
                    IconButton(onClick = { /* TODO: Notification Click */ }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_notification),
                            contentDescription = "Notification"
                        )
                    }
                }
            )
        },
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp),
        bottomBar = { BottomNavigationBar(navController, items) },
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        content = { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(0.dp)
                    .systemBarsPadding(),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                ) {
                    Spacer(modifier = Modifier.height(16.dp))

                    // Greeting and Title
                    Text("Hi User Name", style = MaterialTheme.typography.body1)
                    Text("Study Plan", style = MaterialTheme.typography.h6)

                    Spacer(modifier = Modifier.height(16.dp))

                    // Study Plan Items
                    StudyPlanItem(number = 1, title = "Unit 1: what is examate", isLocked = false)
                    StudyPlanItem(number = 2, title = "Unit 2: what is TCF", isLocked = true)
                    StudyPlanItem(number = 3, title = "Writing Tasks", isLocked = true)
                    StudyPlanItem(number = 4, title = "Oral Task", isLocked = true)

                }
            }
        }
    )
}

@Composable
fun StudyPlanItem(number: Int, title: String, isLocked: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Circle Number with Divider
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(40.dp)
                    .background(
                        color = if (isLocked) Color.Gray else Color(0xFF5B9E96),
                        shape = CircleShape
                    )
            ) {
                Text(text = "$number", color = Color.White)
            }

            Spacer(modifier = Modifier.height(4.dp))
            if (!isLocked) {
                Divider(
                    modifier = Modifier
                        .width(2.dp)
                        .height(24.dp),
                    color = Color.Gray
                )
            }
        }

        Spacer(modifier = Modifier.width(16.dp))

        // Text Content
        Column {
            Text(text = title, style = MaterialTheme.typography.body1)
            if (isLocked) {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Locked",
                    modifier = Modifier.size(16.dp),
                    tint = Color.Gray
                )
            }
        }
    }
}
package com.example.myapplication.ui.connectScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
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
fun ConnectScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Connect",
                    fontSize = fontDimensionResource(id = com.intuit.ssp.R.dimen._15ssp),
                    fontWeight = FontWeight.Bold,
                    color = primaryLight
                ) },
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
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                ) {
                    Spacer(modifier = Modifier.height(16.dp))

                    // Tabs for Suggestions and Chat
                    TabRow(selectedTabIndex = 0) { // Assume the first tab is selected
                        Tab(
                            selected = true,
                            onClick = { /* TODO: Handle Suggestions Tab Click */ },
                            text = { Text("Suggestions") }
                        )
                        Tab(
                            selected = false,
                            onClick = { /* TODO: Handle Chat Tab Click */ },
                            text = { Text("Chat") }
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically) {
                        // Suggested Study Partners Title
                        Text("Suggested Study Partners:", style = MaterialTheme.typography.subtitle1)
                        IconButton(onClick = { /* TODO: Filter Click */ }) {
                            Icon(
                                painter = painterResource(R.drawable.ic_filter_list),
                                contentDescription = "Filter"
                            )
                        }
                    }


                    // List of Partner Cards
                    LazyColumn {
                        items(3) { // Display 3 cards for example; replace with dynamic data
                            PartnerCard()
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun PartnerCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                // Profile Image Placeholder (Circle)
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(primaryLight, shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "RS", color = Color.White)
                }

                Spacer(modifier = Modifier.width(8.dp))

                // User Info
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    // Name and Targeting Badge
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Reem Sayed", style = MaterialTheme.typography.subtitle1)

                        // Targeting Badge
                        Box(
                            modifier = Modifier
                                .background(primaryLight, shape = RoundedCornerShape(4.dp))
                                .padding(horizontal = 8.dp, vertical = 4.dp)
                        ) {
                            Text(
                                "Targeting: B1",
                                color = Color.White,
                                style = MaterialTheme.typography.caption
                            )
                        }
                    }
                }

            }

            Spacer(modifier = Modifier.height(8.dp))

            // Languages
            Row {
                Text("English", style = MaterialTheme.typography.caption)
                Spacer(modifier = Modifier.width(4.dp))
                Text("Arabic", style = MaterialTheme.typography.caption)
                Spacer(modifier = Modifier.width(4.dp))
                Text("French", style = MaterialTheme.typography.caption)
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Additional Info
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(painterResource(id = R.drawable.ic_location), contentDescription = "Location", modifier = Modifier.size(16.dp))
                Text("Egypt", style = MaterialTheme.typography.caption)

                Spacer(modifier = Modifier.width(8.dp))

                Icon(painterResource(id = R.drawable.ic_female), contentDescription = "Gender", modifier = Modifier.size(16.dp))
                Text("Female", style = MaterialTheme.typography.caption)

                Spacer(modifier = Modifier.width(8.dp))

                Icon(painterResource(id = R.drawable.ic_birthday_cake), contentDescription = "Age", modifier = Modifier.size(16.dp))
                Text("26", style = MaterialTheme.typography.caption)

                Spacer(modifier = Modifier.width(8.dp))

                Icon(painterResource(id = R.drawable.ic_calendar), contentDescription = "Join Date", modifier = Modifier.size(16.dp))
                Text("21 June 2023", style = MaterialTheme.typography.caption)
            }
        }
    }
}
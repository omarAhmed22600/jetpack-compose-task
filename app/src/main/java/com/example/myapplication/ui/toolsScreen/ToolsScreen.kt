package com.example.myapplication.ui.toolsScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myapplication.R
import com.example.myapplication.core.utils.fontDimensionResource
import com.example.myapplication.ui.main.BottomNavigationBar
import com.example.myapplication.ui.main.items
import com.example.myapplication.ui.theme.primaryLight

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolsScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Tools",
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
        content = {  padding ->

        }
    )
}
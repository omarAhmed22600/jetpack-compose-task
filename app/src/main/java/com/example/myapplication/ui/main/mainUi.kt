package com.example.myapplication.ui.main

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column


import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.material.Text

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width

import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R
import com.example.myapplication.compositionLocals.STEPS_DONE
import com.example.myapplication.compositionLocals.STEP_CHAT_TUTORIAL
import com.example.myapplication.compositionLocals.STEP_HELP_FILTER_TUTORIAL
import com.example.myapplication.compositionLocals.STEP_HELP_TUTORIAL
import com.example.myapplication.compositionLocals.STEP_HOME_TUTORIAL
import com.example.myapplication.compositionLocals.STEP_WELCOME_SCREEN
import com.example.myapplication.core.navigation.MainNavHost
import com.example.myapplication.core.navigation.Screens
import com.example.myapplication.core.utils.fontDimensionResource
import com.example.myapplication.ui.questionsScreen.FilterButton
import com.example.myapplication.ui.theme.primaryDark
import com.example.myapplication.ui.theme.primaryLight
import timber.log.Timber

val items = listOf(
    NavigationItem.Home,
    NavigationItem.Connector,
    NavigationItem.Questions,
    NavigationItem.Tools,
    NavigationItem.Profile,
)
var tutorialStep by mutableIntStateOf(STEP_WELCOME_SCREEN)
var navBarHeight = 0.dp
var navItemWidth = 0.dp

@Composable
fun MainActivityScreen() {
    Timber.e("Main Screen Recomposed")
    val navController = rememberNavController()
    Timber.e("step:$tutorialStep")
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp)
    ) {

        MainNavHost(navController)
        if (tutorialStep == STEP_WELCOME_SCREEN)
            WelcomeScreen(navController)
        if (tutorialStep == STEP_HOME_TUTORIAL)
            HomeTutorialScreen(navController = navController)
        if (tutorialStep == STEP_CHAT_TUTORIAL)
            ChatTutorialScreen(navController)
        if (tutorialStep == STEP_HELP_TUTORIAL)
            HelpTutorialScreen(navController)


    }
}

@Composable
fun HelpTutorialScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.semi_trans))
    )
    {
        Row(
            Modifier.align(Alignment.BottomStart),

            ) {

            Box(
                modifier = Modifier
                    .width(navItemWidth)
                    .background(colorResource(id = R.color.transparent))
            )
            Box(
                modifier = Modifier
                    .width(navItemWidth)
                    .background(colorResource(id = R.color.transparent))
            )
            Column(
                Modifier
                    .align(Alignment.Bottom)
                    .padding(
                        start = dimensionResource(id = com.intuit.sdp.R.dimen._2sdp),
                    ),
            ) {
                TooltipOverlay("Vous trouverez ici votre plan d'étude")
                Button(
                    onClick = {
                        tutorialStep = STEP_HELP_FILTER_TUTORIAL

                    },
                    Modifier
                        .background(Color.White)
                        .height(navBarHeight)
                        .width(navItemWidth + 5.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White // Set the background color to white
                    )
                ) {
                    Column(
                        Modifier
                            .padding(bottom = dimensionResource(id = com.intuit.sdp.R.dimen._11sdp))
                    ) {
                        val item = items[2]
                        Image(
                            painter = painterResource(
                                id = item.activeIcon,
                            ),
                            contentDescription = stringResource(id = item.title),
                            modifier = Modifier
                                .size(24.dp) // Adjust icon size if needed
                                .align(Alignment.CenterHorizontally)
                                .padding(bottom = 2.dp) // Ensure proper spacing
                        )
                        Text(
                            text = stringResource(id = item.title),
                            fontFamily = FontFamily(
                                Font(
                                    R.font.montserrat_semibold

                                )
                            ),
                            textAlign = TextAlign.Center,
                            fontSize = fontDimensionResource(id = com.intuit.ssp.R.dimen._3ssp),
                            color = primaryLight,
                            modifier = Modifier
                                .padding(top = 2.dp)
                                .align(Alignment.CenterHorizontally)// Adjust padding as needed
                                .fillMaxWidth()
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun HomeTutorialScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.semi_trans))
    )
    {
        Row(
            Modifier.align(Alignment.BottomStart),

            ) {

            Column(
                Modifier
                    .align(Alignment.Bottom)
                    .padding(
                        start = dimensionResource(id = com.intuit.sdp.R.dimen._2sdp),
                    ),
            ) {
                TooltipOverlay("Vous trouverez ici votre plan d'étude")
                Button(
                    onClick = {
                        tutorialStep = STEP_CHAT_TUTORIAL
                        navController.navigateUp()
                        navController.navigate(Screens.CONNECTOR_SCREEN_NAV)
                    },
                    Modifier
                        .background(Color.White)
                        .height(navBarHeight)
                        .width(navItemWidth),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White // Set the background color to white
                    )
                ) {
                    Column(
                        Modifier
                            .padding(bottom = dimensionResource(id = com.intuit.sdp.R.dimen._11sdp))
                    ) {
                        val item = items[0]
                        Image(
                            painter = painterResource(
                                id = item.activeIcon
                            ),
                            contentDescription = stringResource(id = item.title),
                            modifier = Modifier
                                .size(24.dp) // Adjust icon size if needed
                                .padding(bottom = 2.dp) // Ensure proper spacing
                                .align(Alignment.CenterHorizontally)
                        )
                        Text(
                            text = stringResource(id = item.title),
                            fontFamily = FontFamily(
                                Font(
                                    R.font.montserrat_semibold

                                )
                            ),
                            fontSize = fontDimensionResource(id = com.intuit.ssp.R.dimen._5ssp),
                            color = primaryLight,
                            modifier = Modifier
                                .padding(top = 2.dp) // Adjust padding as needed
                                .align(Alignment.CenterHorizontally)

                        )
                    }

                }
            }


        }
    }
}

@Composable
fun ChatTutorialScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.semi_trans))
    )
    {
        Row(
            Modifier.align(Alignment.BottomStart),

            ) {

            Box(
                modifier = Modifier
                    .width(navItemWidth)
                    .background(colorResource(id = R.color.transparent))
            )
            Column(
                Modifier
                    .align(Alignment.Bottom)
                    .padding(
                        start = dimensionResource(id = com.intuit.sdp.R.dimen._2sdp),
                    ),
            ) {
                TooltipOverlay("Vous trouverez ici des partenaires d'étude et des personnes avec qui vous connecter")
                Button(
                    onClick = {
                        tutorialStep = STEP_HELP_TUTORIAL
                        navController.navigateUp()
                        navController.navigate(Screens.QUESTIONS_SCREEN_NAV)
                    },
                    Modifier
                        .background(Color.White)
                        .height(navBarHeight)
                        .width(navItemWidth + 5.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White // Set the background color to white
                    )
                ) {
                    Column(
                        Modifier
                            .padding(bottom = dimensionResource(id = com.intuit.sdp.R.dimen._11sdp))
                    ) {
                        val item = items[1]
                        Image(
                            painter = painterResource(
                                id = item.activeIcon,
                            ),
                            contentDescription = stringResource(id = item.title),
                            modifier = Modifier
                                .size(24.dp) // Adjust icon size if needed
                                .align(Alignment.CenterHorizontally)
                                .padding(bottom = 2.dp) // Ensure proper spacing
                        )
                        Text(
                            text = stringResource(id = item.title),
                            fontFamily = FontFamily(
                                Font(
                                    R.font.montserrat_semibold

                                )
                            ),
                            textAlign = TextAlign.Center,
                            fontSize = fontDimensionResource(id = com.intuit.ssp.R.dimen._4ssp),
                            color = primaryLight,
                            modifier = Modifier
                                .padding(top = 2.dp)
                                .align(Alignment.CenterHorizontally)// Adjust padding as needed
                                .fillMaxWidth()
                        )
                    }

                }
            }


        }
    }
}

@Composable
fun TooltipOverlay(message: String) {
    Column(
        modifier = Modifier
            .width(dimensionResource(id = com.intuit.sdp.R.dimen._200sdp))
    ) {
        Box(
            modifier = Modifier
                .background(Color.Black.copy(alpha = 0.8f), shape = RoundedCornerShape(8.dp))
                .padding(
                    3.dp
                )
        ) {
            Text(
                text = message,
                color = Color.White,
                fontSize = fontDimensionResource(id = com.intuit.ssp.R.dimen._10ssp),
                fontWeight = FontWeight.Bold
            )
        }
        TriangleShape(Color.Black.copy(alpha = 0.8f))
        Spacer(modifier = Modifier.height(4.dp)) // Small gap between tooltip and button

    }
}

@Composable
fun TriangleShape(color: Color, size: Dp = 10.dp) {
    Canvas(
        modifier = Modifier
            .size(size)
            .padding(start = dimensionResource(id = com.intuit.sdp.R.dimen._8sdp))
    ) {
        val path = Path().apply {
            moveTo(size.toPx() / 2, size.toPx()) // Bottom point of triangle
            lineTo(0f, 0f) // Top left
            lineTo(size.toPx(), 0f) // Top right
            close()
        }
        drawPath(path = path, color = color)
    }
}

@Composable
fun BottomNavigationBar(navController: NavController, items: List<NavigationItem>) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    var currentRoute =
        if (tutorialStep == STEP_WELCOME_SCREEN || tutorialStep == STEPS_DONE || tutorialStep == STEP_HOME_TUTORIAL) navBackStackEntry?.destination?.route else if (tutorialStep == STEP_CHAT_TUTORIAL) Screens.CONNECTOR_SCREEN_NAV else Screens.QUESTIONS_SCREEN_NAV
    val density = LocalDensity.current
    Timber.e("current route is $currentRoute")
    NavigationBar(
        containerColor = Color.White,
        tonalElevation = 5.dp,
        modifier = Modifier
            .wrapContentHeight()
            .onGloballyPositioned { coordinates ->
                // Capture the height of the NavigationBar
//                if (navBarHeight == 0.dp)
                navBarHeight = with(density) { coordinates.size.height.toDp() }
            },

        ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            items.forEach { item ->
                NavigationBarItem(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(vertical = 4.dp)
                        .onGloballyPositioned { coordinates ->
                            // Capture the height of the NavigationBar
                            if (navItemWidth == 0.dp)
                                navItemWidth = with(density) { coordinates.size.width.toDp() }
                        }, // Adjust padding as needed
                    icon = {
                        Image(
                            painter = painterResource(
                                id = if (currentRoute == item.route) item.activeIcon else item.icon
                            ),
                            contentDescription = stringResource(id = item.title),
                            modifier = Modifier
                                .size(24.dp) // Adjust icon size if needed
                                .padding(bottom = 2.dp) // Ensure proper spacing
                        )
                    },
                    label = {
                        Text(
                            text = stringResource(id = item.title),
                            fontFamily = FontFamily(
                                Font(
                                    if (currentRoute == item.route) R.font.montserrat_semibold
                                    else R.font.montserrat
                                )
                            ),
                            fontSize = fontDimensionResource(id = com.intuit.ssp.R.dimen._5ssp),
                            color = if (currentRoute == item.route) primaryLight else Color.Gray,
                            modifier = Modifier.padding(top = 2.dp) // Adjust padding as needed
                        )
                    },
                    selected = currentRoute == item.route,
                    onClick = {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.White
                    )
                )
            }
        }
    }
}

sealed class NavigationItem(
    var route: String,
    var icon: Int,
    var activeIcon: Int,
    var title: Int
) {
    object Home : NavigationItem(
        Screens.HOME_SCREEN_NAV, R.drawable.ic_home, R.drawable.ic_home_active,
        R.string.home_title
    )

    object Connector : NavigationItem(
        Screens.CONNECTOR_SCREEN_NAV, R.drawable.ic_chat, R.drawable.ic_chat_active,
        R.string.connect_title
    )

    object Questions : NavigationItem(
        Screens.QUESTIONS_SCREEN_NAV,
        R.drawable.ic_questions,
        R.drawable.ic_questions_active,
        R.string.questions
    )

    object Tools : NavigationItem(
        Screens.TOOLS_SCREEN_NAV,
        R.drawable.ic_tools,
        R.drawable.ic_tools_active,
        R.string.tools_title
    )

    object Profile : NavigationItem(
        Screens.PROFILE_SCREEN_NAV,
        R.drawable.ic_profile,
        R.drawable.ic_profile_active,
        R.string.profile_title
    )
}


@Composable
fun WelcomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                tutorialStep = STEP_HOME_TUTORIAL
            }
            .background(colorResource(id = R.color.semi_black)),
        contentAlignment = Alignment.Center,
    )
    {
        Column {
            Text(
                text = stringResource(R.string.welcome_title),
                textAlign = TextAlign.Center,
                fontSize = fontDimensionResource(
                    id = com.intuit.ssp.R.dimen._16ssp
                ),
                color = Color.White
            )
            Text(
                text = stringResource(R.string.tap_anywhere_on_the_screen_to_continue),
                textAlign = TextAlign.Center,
                fontSize = fontDimensionResource(
                    id = com.intuit.ssp.R.dimen._20ssp
                ),
                color = primaryDark
            )

        }

    }
}


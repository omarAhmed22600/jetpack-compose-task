package com.example.myapplication.ui.questionsScreen


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.compositionLocals.STEPS_DONE
import com.example.myapplication.compositionLocals.STEP_HELP_FILTER_TUTORIAL
import com.example.myapplication.compositionLocals.STEP_HELP_GRID_TUTORIAL
import com.example.myapplication.core.navigation.Screens
import com.example.myapplication.core.utils.fontDimensionResource
import com.example.myapplication.ui.main.BottomNavigationBar
import com.example.myapplication.ui.main.TooltipOverlay
import com.example.myapplication.ui.main.items
import com.example.myapplication.ui.main.navBarHeight
import com.example.myapplication.ui.main.tutorialStep
import com.example.myapplication.ui.theme.onPrimaryDark
import com.example.myapplication.ui.theme.primaryContainerLight
import com.example.myapplication.ui.theme.primaryDark
import com.example.myapplication.ui.theme.primaryLight

// Data class representing a Question object
data class Question(
    val category: String,
    val task: String,
    val questionText: String,
    val answerCount: String,
    val date: String
)
// Data class for QuestionCard data representation
data class QuestionCardData(
    val category: String,
    val answeredQuestions: Int,
    val totalQuestions: Int,
    val progress: Int
)
// Sample list of questions to be displayed
val questions = listOf(
    Question(
        category = "Events",
        task = "Task 2",
        questionText = "Je suis votre collègue, je participe chaque année à une course à pieds pour célébrer le printemps. Vous êtes intéressé. Vous me posez des questions pour avoir des informations (parcours, durée, participants, etc.)",
        answerCount = "11 answers",
        date = "13 May 2023"
    ),
    Question(
        category = "Technology",
        task = "Task 3",
        questionText = "Quand quelqu'un quitte son pays pour aller vivre ailleurs, c'est souvent parce qu'il n'a pas d'autre choix. Qu'en pensez-vous ?",
        answerCount = "11 answers",
        date = "13 May 2023"
    ),
    Question(
        category = "Culture",
        task = "Task 3",
        questionText = "What are the advantages and disadvantages of a multicultural society?",
        answerCount = "11 answers",
        date = "13 May 2023"
    )
)
// Dummy data for question grid items
val dummyData = listOf(
    QuestionCardData("Voyage", 10, 10, 100),
    QuestionCardData("Immigration", 5, 10, 50),
    QuestionCardData("Technologie", 5, 10, 50),
    QuestionCardData("Art et Culture", 5, 10, 50),
    QuestionCardData("Environnement", 5, 10, 50),
    QuestionCardData("Travel", 5, 10, 50),
    QuestionCardData("Art et Culture", 5, 10, 50),
    QuestionCardData("Environnement", 5, 10, 50),
    QuestionCardData("Travel", 5, 10, 50)
)
// Tabs and corresponding icons for the UI
val tabs = listOf("Writing", "Oral")
val tabIcons = listOf(
    R.drawable.ic_writting, // Replace with actual icons
    R.drawable.ic_mic
)
// Global state object for managing tab selection
object GlobalState {
    var selectedTabIndex by mutableStateOf(1)
}
// Main Questions Screen Composable
@Composable
fun QuestionsScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize())
    {

        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp),
            bottomBar = { BottomNavigationBar(navController, items) },
            contentWindowInsets = WindowInsets(0, 0, 0, 0),
            content = { padding ->
                Box(
                    modifier = if (tutorialStep == STEP_HELP_FILTER_TUTORIAL) Modifier
                        .fillMaxSize()
                        .padding(0.dp)
                        .systemBarsPadding()
                    else
                        Modifier
                            .fillMaxSize()
                            .padding(0.dp)
                            .systemBarsPadding()
                ) {
                    Column(
                        modifier =
                        Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        // Header
                        Text(
                            text = stringResource(id = R.string.questions),
                            fontSize = fontDimensionResource(id = com.intuit.ssp.R.dimen._15ssp),
                            fontWeight = FontWeight.Bold,
                            color = primaryLight
                        )

                        Spacer(modifier = Modifier.height(dimensionResource(id = com.intuit.sdp.R.dimen._16sdp)))
                        // Tab Row for Writing and Oral tabs
                        TabRow(
                            selectedTabIndex = GlobalState.selectedTabIndex,
                            contentColor = primaryLight, // Active tab color
                            indicator = { tabPositions ->
                                TabRowDefaults.Indicator(
                                    Modifier
                                        .tabIndicatorOffset(tabPositions[GlobalState.selectedTabIndex])
                                        .height(4.dp)
                                        .background(
                                            primaryLight,
                                            shape = RoundedCornerShape(50)
                                        ) // Rounded tab indicator
                                )
                            },
                            containerColor = Color.Transparent,
                        ) {
                            tabs.forEachIndexed { index, tabLabel ->
                                Tab(
                                    selected = GlobalState.selectedTabIndex == index,
                                    onClick = { GlobalState.selectedTabIndex = index },
                                    text = {
                                        Text(
                                            text = tabLabel,
                                            fontSize = fontDimensionResource(id = com.intuit.ssp.R.dimen._10ssp),
                                            fontWeight = FontWeight.Bold,
                                            color = if (GlobalState.selectedTabIndex == index)
                                                primaryLight
                                            else
                                                Color.Gray
                                        )
                                    },
                                    icon = {
                                        Icon(
                                            painter = painterResource(id = tabIcons[index]), // Icon corresponding to the tab
                                            contentDescription = null,
                                            modifier = Modifier.size(24.dp),
                                            tint = if (GlobalState.selectedTabIndex == index)
                                                primaryLight
                                            else
                                                Color.Gray
                                        )
                                    },
                                    selectedContentColor = primaryLight,
                                    unselectedContentColor = Color.Gray
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(dimensionResource(id = com.intuit.sdp.R.dimen._20sdp)))
                        // Filter Button
                        FilterButton()

                        Spacer(modifier = Modifier.height(dimensionResource(id = com.intuit.sdp.R.dimen._10sdp)))
                        // Display Question List or Grid based on selected tab
                        if (GlobalState.selectedTabIndex == 1) {
                            // LazyColumn displaying questions in a list format
                            LazyColumn(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(bottom = navBarHeight), // Add bottom padding to prevent cut-off
                                verticalArrangement = Arrangement.spacedBy(8.dp)

                            ) {
                                items(questions) { question ->
                                    QuestionCard(
                                        category = question.category,
                                        task = question.task,
                                        question = question.questionText,
                                        answerCount = question.answerCount,
                                        date = question.date
                                    )
                                }

                            }
                        } else {
                            // LazyVerticalGrid displaying questions in a grid format
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(bottom = navBarHeight), // Add bottom padding to prevent cut-off
                            ) {
                                LazyVerticalGrid(
                                    columns = GridCells.Fixed(2), // 2 columns in the grid
                                    verticalArrangement = Arrangement.spacedBy(16.dp),
                                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                                ) {
                                    items(dummyData) { question ->
                                        QuestionGridItem(question, navController)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        )
        // If the user enters the screen for the tutorial
        if (tutorialStep == STEP_HELP_FILTER_TUTORIAL) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(colorResource(id = R.color.semi_trans)),
                contentAlignment = Alignment.TopStart // Align at the same position as inside Column
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                        .offset(
                            0.dp,
                            dimensionResource(id = com.intuit.sdp.R.dimen._90sdp)
                        )
                ) {
                    TooltipOverlay(message = "Vous pouvez filtrer pour voir un type exact de questions")
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                        .offset(
                            0.dp,
                            dimensionResource(id = com.intuit.sdp.R.dimen._140sdp)
                        )
                ) {
                    FilterButton()
                }
            }
        }
        if (tutorialStep == STEP_HELP_GRID_TUTORIAL) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(colorResource(id = R.color.semi_trans)),
                contentAlignment = Alignment.TopStart // Align at the same position as inside Column
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                        .offset(
                            0.dp,
                            dimensionResource(id = com.intuit.sdp.R.dimen._130sdp)
                        )
                ) {
                    TooltipOverlay(message = "Cliquez ici pour voir par catégories avec progression")
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                        .offset(
                            0.dp,
                            dimensionResource(id = com.intuit.sdp.R.dimen._180sdp)
                        )
                ) {
                    TutorialGrid(navController)
                }
            }
        }

    }

}

@Composable
fun TutorialGrid(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), // 2 columns in the grid
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(dummyData) { index, item ->
                if (index == 0)
                    QuestionGridItem(item, navController = navController)
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun QuestionGridItem(data: QuestionCardData, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .clickable {
                if (tutorialStep == STEP_HELP_GRID_TUTORIAL) {
                    tutorialStep = STEPS_DONE
                    GlobalState.selectedTabIndex = 0
                    navController.popBackStack()
                    navController.navigate(Screens.HOME_SCREEN_NAV)
                } else {

                }
            },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),  // Correct way to set elevation
        colors = CardDefaults.cardColors(     // Use `colors` to set the background
            containerColor = Color.White      // Set the background color here
        ),
        border = BorderStroke(1.dp, Color.Gray.copy(alpha = 0.3f)) // Light border
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(primaryDark)
                    .padding(dimensionResource(id = com.intuit.sdp.R.dimen._3sdp)),
            )
            {
                Text(
                    text = "${data.answeredQuestions} sur ${data.totalQuestions} Questions",
                    fontWeight = FontWeight.Bold,
                    fontSize = fontDimensionResource(id = com.intuit.ssp.R.dimen._6ssp),
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }


            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_technology), // Replace with your icon
                    contentDescription = null,
                    tint = primaryLight,
                    modifier = Modifier.size(24.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    modifier = Modifier
                        .basicMarquee(),
                    text = data.category,
                    fontWeight = FontWeight.Bold,
                    fontSize = fontDimensionResource(id = com.intuit.ssp.R.dimen._9ssp),
                    color = Color.Black,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            // Progress Bar
            Column {
                Text(
                    text = "Progress ${data.progress}%",
                    fontSize = fontDimensionResource(id = com.intuit.ssp.R.dimen._8ssp),
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(4.dp))
                LinearProgressIndicator(
                    progress = data.progress / 100f,
                    modifier = Modifier.fillMaxWidth(),
                    color = primaryLight,
                    trackColor = Color.Gray.copy(alpha = 0.3f) // Track color is now `trackColor`
                )
            }
        }
    }
}

@Composable
fun FilterButton() {
    Button(
        modifier =
        Modifier
            .height(40.dp),
        onClick = {
            if (tutorialStep == STEP_HELP_FILTER_TUTORIAL) {
                tutorialStep = STEP_HELP_GRID_TUTORIAL
                GlobalState.selectedTabIndex = 0
            } else {
                //do original thing
            }
        },

        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.filter_button_background),
            contentColor = colorResource(id = R.color.filter_button_text)
        ),
        shape = RoundedCornerShape(8.dp),
    ) {
        Text(

            text = stringResource(id = R.string.filter),
            fontSize = fontDimensionResource(id = com.intuit.ssp.R.dimen._10ssp),
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.size(dimensionResource(id = com.intuit.sdp.R.dimen._2sdp)))
        Icon(
            painter = painterResource(id = R.drawable.ic_filter_list),
            contentDescription = null,
            modifier = Modifier
                .size(dimensionResource(id = com.intuit.sdp.R.dimen._13sdp))

        )
    }
}

@Composable
fun QuestionCard(
    category: String,
    task: String,
    question: String,
    answerCount: String,
    date: String
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = category,
                    fontSize = fontDimensionResource(id = com.intuit.ssp.R.dimen._8ssp),
                    color = colorResource(id = R.color.category_text),
                    modifier = Modifier
                        .background(primaryContainerLight)
                        .padding(2.dp)
                )
                Text(
                    text = task,
                    fontSize = fontDimensionResource(id = com.intuit.ssp.R.dimen._8ssp),
                    color = colorResource(id = R.color.task_text),
                    modifier = Modifier
                        .background(primaryContainerLight)
                        .padding(2.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = question,
                fontSize = fontDimensionResource(id = com.intuit.ssp.R.dimen._10ssp),
                color = colorResource(id = R.color.primary_text)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = answerCount,
                    fontSize = fontDimensionResource(id = com.intuit.ssp.R.dimen._8ssp),
                    color = colorResource(id = R.color.secondary_text)
                )
                Text(
                    text = date,
                    fontSize = fontDimensionResource(id = com.intuit.ssp.R.dimen._8ssp),
                    color = colorResource(id = R.color.secondary_text)
                )
            }
        }
    }
}

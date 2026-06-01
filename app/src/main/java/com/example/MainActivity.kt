package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.model.Chapters
import com.example.ui.screens.ChapterDetailScreen
import com.example.ui.screens.GlossaryScreen
import com.example.ui.screens.LandingScreen
import com.example.ui.theme.DarkWood
import com.example.ui.theme.ParchmentBackground
import com.example.ui.theme.TheOneSourceTheme
import com.example.ui.theme.WheatSecondary
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TheOneSourceTheme {
                MainContent()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = DarkWood,
                drawerContentColor = WheatSecondary
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(
                        text = "THE ONE SOURCE",
                        style = MaterialTheme.typography.titleLarge,
                        color = WheatSecondary,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    HorizontalDivider(color = WheatSecondary.copy(alpha = 0.3f))
                    Spacer(modifier = Modifier.height(16.dp))

                    NavigationDrawerItem(
                        label = { Text("Preface & Orientation") },
                        selected = false,
                        onClick = {
                            scope.launch { drawerState.close() }
                            navController.navigate(Screen.Landing)
                        },
                        colors = NavigationDrawerItemDefaults.colors(
                            unselectedContainerColor = Color.Transparent,
                            unselectedTextColor = WheatSecondary
                        )
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "The Seven Centers",
                        style = MaterialTheme.typography.labelLarge,
                        color = WheatSecondary.copy(alpha = 0.7f),
                        modifier = Modifier.padding(start = 12.dp, bottom = 8.dp)
                    )

                    Chapters.forEach { chapter ->
                        NavigationDrawerItem(
                            label = { Text(chapter.title.split(" — ").last()) },
                            selected = false,
                            onClick = {
                                scope.launch { drawerState.close() }
                                navController.navigate(Screen.ChapterDetail(chapter.id))
                            },
                            colors = NavigationDrawerItemDefaults.colors(
                                unselectedContainerColor = Color.Transparent,
                                unselectedTextColor = WheatSecondary
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    HorizontalDivider(color = WheatSecondary.copy(alpha = 0.3f))
                    Spacer(modifier = Modifier.height(16.dp))

                    NavigationDrawerItem(
                        label = { Text("Glossary") },
                        selected = false,
                        onClick = {
                            scope.launch { drawerState.close() }
                            navController.navigate(Screen.Glossary)
                        },
                        colors = NavigationDrawerItemDefaults.colors(
                            unselectedContainerColor = Color.Transparent,
                            unselectedTextColor = WheatSecondary
                        )
                    )
                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            "THE ONE SOURCE",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.SemiBold,
                            letterSpacing = 1.sp
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = DarkWood,
                        titleContentColor = WheatSecondary,
                        navigationIconContentColor = WheatSecondary
                    )
                )
            },
            containerColor = ParchmentBackground
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                NavHost(navController = navController, startDestination = Screen.Landing) {
                    composable<Screen.Landing> {
                        LandingScreen(
                            onReadChapter = { chapterId ->
                                navController.navigate(Screen.ChapterDetail(chapterId))
                            }
                        )
                    }
                    composable<Screen.ChapterDetail> { backStackEntry ->
                        val chapterDetail = backStackEntry.toRoute<Screen.ChapterDetail>()
                        ChapterDetailScreen(chapterId = chapterDetail.chapterId)
                    }
                    composable<Screen.Glossary> {
                        GlossaryScreen()
                    }
                }
            }
        }
    }
}

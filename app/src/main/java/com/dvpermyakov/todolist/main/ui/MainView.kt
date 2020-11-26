package com.dvpermyakov.todolist.main.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.dvpermyakov.todolist.add.ui.AddTodoView
import com.dvpermyakov.todolist.detaills.ui.TodoItemDetails
import com.dvpermyakov.todolist.list.ui.TodoListView
import com.dvpermyakov.todolist.main.Screen
import com.dvpermyakov.todolist.main.createRoute

@Composable
fun MainView() {
    MaterialTheme(
        colors = lightColors()
    ) {
        val navController = rememberNavController()
        NavHost(navController, startDestination = Screen.TodoList.route) {
            composable(Screen.TodoList.route) {
                TodoListView(
                    onAddClick = {
                        navController.navigate(Screen.AddTodoItem.route)
                    },
                    onItemClick = { item ->
                        navController.navigate(Screen.TodoItemDetails.createRoute(item))
                    }
                )
            }
            composable(Screen.AddTodoItem.route) {
                AddTodoView(
                    onBack = {
                        navController.popBackStack()
                    }
                )
            }
            composable(
                route = Screen.TodoItemDetails.route,
                arguments = listOf(
                    navArgument("itemId") { type = NavType.StringType }
                )
            ) { entry ->
                entry.arguments?.getString("itemId")?.let { itemId ->
                    TodoItemDetails(
                        onBack = {
                            navController.popBackStack()
                        },
                        itemId = itemId
                    )
                }
            }
        }
    }
}
package com.dvpermyakov.todolist.main.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.dvpermyakov.todolist.R
import com.dvpermyakov.todolist.add.ui.AddTodoView
import com.dvpermyakov.todolist.detaills.ui.TodoItemDetails
import com.dvpermyakov.todolist.list.domain.TodoItem
import com.dvpermyakov.todolist.list.ui.TodoListView

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
                        navController.navigate(Screen.TodoItemDetails.route)
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
            composable(Screen.TodoItemDetails.route) { entry ->
                TodoItemDetails(
                    item = TodoItem(R.drawable.ic_cat, "title", "description"),
                    onBack = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}
package com.dvpermyakov.todolist.main

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.dvpermyakov.todolist.add.ui.AddTodoView
import com.dvpermyakov.todolist.detaills.ui.TodoItemDetails
import com.dvpermyakov.todolist.list.ui.TodoListView

@Composable
fun MainView() {
    MaterialTheme {
        val currentScreen = remember { mutableStateOf<Screen>(Screen.TodoList) }
        when (currentScreen.value) {
            is Screen.TodoList -> {
                TodoListView(
                    onAddClick = {
                        currentScreen.value = Screen.AddTodoItem
                    },
                    onItemClick = { item ->
                        currentScreen.value = Screen.TodoItemDetails(item)
                    }
                )
            }
            is Screen.AddTodoItem -> {
                AddTodoView(
                    onBack = {
                        currentScreen.value = Screen.TodoList
                    },
                    onSuccess = { value ->
                        currentScreen.value = Screen.TodoList
                    }
                )
            }
            is Screen.TodoItemDetails -> {
                TodoItemDetails()
            }
        }
    }
}
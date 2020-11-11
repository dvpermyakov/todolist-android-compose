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
                TodoListView(currentScreen)
            }
            is Screen.AddTodoItem -> {
                AddTodoView()
            }
            is Screen.TodoItemDetails -> {
                TodoItemDetails()
            }
        }
    }
}
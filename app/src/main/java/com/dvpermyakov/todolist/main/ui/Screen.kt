package com.dvpermyakov.todolist.main.ui

sealed class Screen(val route: String) {
    object TodoList : Screen("list")
    object TodoItemDetails : Screen("details")
    object AddTodoItem : Screen("add")
}
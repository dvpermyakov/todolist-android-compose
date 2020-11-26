package com.dvpermyakov.todolist.main

import com.dvpermyakov.todolist.list.domain.TodoItem

sealed class Screen(val route: String) {
    object TodoList : Screen("list")
    object TodoItemDetails : Screen("details/{itemId}")
    object AddTodoItem : Screen("add")
}

fun Screen.TodoItemDetails.createRoute(item: TodoItem): String {
    return "details/${item.id}"
}
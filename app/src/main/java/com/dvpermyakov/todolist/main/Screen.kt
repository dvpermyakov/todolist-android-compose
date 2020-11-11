package com.dvpermyakov.todolist.main

import com.dvpermyakov.todolist.list.domain.TodoItem

sealed class Screen {
    object TodoList : Screen()
    data class TodoItemDetails(val item: TodoItem) : Screen()
    object AddTodoItem : Screen()
}
package com.dvpermyakov.todolist.list.ui

import androidx.compose.foundation.Icon
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import androidx.ui.tooling.preview.Preview
import com.dvpermyakov.todolist.R
import com.dvpermyakov.todolist.list.presentation.TodoListViewModel
import com.dvpermyakov.todolist.list.ui.children.TodoAlertDialog
import com.dvpermyakov.todolist.list.ui.children.TodoItemView
import com.dvpermyakov.todolist.main.Screen

@Composable
fun TodoListView(
    screenState: MutableState<Screen>,
    viewModel: TodoListViewModel = viewModel()
) {
    val openDialog = remember { mutableStateOf(true) }
    if (openDialog.value) {
        TodoAlertDialog {
            openDialog.value = false
        }
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(R.string.app_name))
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                screenState.value = Screen.AddTodoItem
            }) {
                Icon(Icons.Default.Add)
            }
        }
    ) {
        ScrollableColumn(
            contentPadding = PaddingValues(8.dp)
        ) {
            viewModel.items.forEach { item ->
                TodoItemView(
                    item = item,
                    onClick = { todoItem ->
                        screenState.value = Screen.TodoItemDetails(todoItem)
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewTodoList() {
//    TodoListView(mutableListOf(Router.Screen.AddTodo))
}
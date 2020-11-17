package com.dvpermyakov.todolist.list.ui

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import androidx.ui.tooling.preview.Preview
import com.dvpermyakov.todolist.R
import com.dvpermyakov.todolist.list.domain.TodoItem
import com.dvpermyakov.todolist.list.presentation.TodoListViewModel
import com.dvpermyakov.todolist.list.ui.children.TodoAlertDialog
import com.dvpermyakov.todolist.list.ui.children.TodoItemView

@Composable
fun TodoListView(
    onAddClick: () -> Unit,
    onItemClick: (TodoItem) -> Unit,
    viewModel: TodoListViewModel = viewModel()
) {
    val openDialog = viewModel.showDialog.observeAsState(initial = false)
    if (openDialog.value) {
        TodoAlertDialog {
            viewModel.dialogShown()
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
            FloatingActionButton(onClick = onAddClick) {
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
                    onClick = {
                        onItemClick(item)
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewTodoList() {
    TodoListView({}, {})
}
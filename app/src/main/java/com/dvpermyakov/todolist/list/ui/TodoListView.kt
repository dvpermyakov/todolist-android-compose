package com.dvpermyakov.todolist.list.ui

import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import androidx.ui.tooling.preview.Preview
import com.dvpermyakov.todolist.R
import com.dvpermyakov.todolist.list.domain.TodoItem
import com.dvpermyakov.todolist.list.presentation.TodoListViewModel
import com.dvpermyakov.todolist.list.ui.children.TodoAlertDialog
import com.dvpermyakov.todolist.list.ui.children.TodoItemView
import com.dvpermyakov.todolist.list.ui.children.TodoLoadingView
import com.dvpermyakov.todolist.main.ViewModelFactory

@Composable
fun TodoListView(
    onAddClick: () -> Unit,
    onItemClick: (TodoItem) -> Unit,
    viewModel: TodoListViewModel = viewModel(factory = ViewModelFactory)
) {
    val loading = viewModel.loading.observeAsState(initial = true)
    val items = viewModel.items.observeAsState()

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
                },
                actions = {
                    IconButton(onClick = {
                        viewModel.addDefaultTodoItem()
                    }) {
                        Icon(Icons.Filled.Add)
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddClick) {
                Icon(Icons.Default.Add)
            }
        }
    ) {
        Crossfade(
            current = loading,
            animation = tween()
        ) { loadingState ->
            if (loadingState.value) {
                TodoLoadingView()
            } else {
                ScrollableColumn(
                    modifier = Modifier.animateContentSize(),
                    contentPadding = PaddingValues(8.dp)
                ) {
                    items.value?.forEach { item ->
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
    }
}

@Preview
@Composable
fun PreviewTodoList() {
    TodoListView({}, {})
}
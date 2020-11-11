package com.dvpermyakov.todolist.home.ui

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import androidx.ui.tooling.preview.Preview
import com.dvpermyakov.todolist.R
import com.dvpermyakov.todolist.home.presentation.HomeViewModel

@Composable
fun TodoListView(
    viewModel: HomeViewModel = viewModel()
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(R.string.app_name))
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = viewModel::onAddClick) {
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
                        viewModel.onTodoItemClick(todoItem)
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewTodoList() {
    TodoListView()
}
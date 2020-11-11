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
import androidx.ui.tooling.preview.Preview
import com.dvpermyakov.todolist.R

@Composable
fun TodoListView(
    items: List<TodoItem>,
    onAddClick: () -> Unit,
    onItemClick: (TodoItem) -> Unit
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
            FloatingActionButton(onClick = onAddClick) {
                Icon(Icons.Default.Add)
            }
        }
    ) {
        ScrollableColumn(
            contentPadding = PaddingValues(8.dp)
        ) {
            items.forEach { item ->
                TodoItemView(item = item, onClick = onItemClick)
            }
        }
    }
}

@Preview
@Composable
fun PreviewTodoList() {
    val item = TodoItem(
        image = 0,
        title = "Need to improve android article about Compose",
        description = "Need not only improve, but rewrite some code as well. Good to do it as soon as possible"
    )
    val item2 = TodoItem(
        image = R.drawable.ic_cat,
        title = "1",
        description = "1"
    )
    TodoListView(
        items = listOf(item, item, item, item2),
        onAddClick = {},
        onItemClick = {}
    )
}
package com.dvpermyakov.todolist.detaills.ui

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.dvpermyakov.todolist.R
import com.dvpermyakov.todolist.list.domain.TodoItem

@Composable
fun TodoItemDetails(
    item: TodoItem,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(R.string.todo_item_details_appbar, item.title))
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Filled.ArrowBack)
                    }
                },
            )
        }
    ) {
    }
}
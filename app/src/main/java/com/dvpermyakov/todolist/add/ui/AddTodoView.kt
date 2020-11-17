package com.dvpermyakov.todolist.add.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import androidx.ui.tooling.preview.Preview
import com.dvpermyakov.todolist.R
import com.dvpermyakov.todolist.add.presentation.AddTodoViewModel
import com.dvpermyakov.todolist.list.domain.TodoItem
import com.dvpermyakov.todolist.main.ui.ViewModelFactory

@Composable
fun AddTodoView(
    onBack: () -> Unit,
    viewModel: AddTodoViewModel = viewModel(factory = ViewModelFactory)
) {
    val titleState = remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(R.string.add_todo_appbar))
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Filled.ArrowBack)
                    }
                },
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.addItem(
                    TodoItem(
                        image = R.drawable.ic_cat,
                        title = titleState.value,
                        description = titleState.value
                    )
                )
            }) {
                Icon(
                    asset = Icons.Default.Done
                )
            }
        }
    ) {
        TextField(
            value = titleState.value,
            onValueChange = { value ->
                titleState.value = value
            },
            modifier = Modifier.padding(8.dp),
            label = { Text(stringResource(R.string.add_todo_title_label)) }
        )
    }
}

@Preview
@Composable
fun PreviewAddTodoView() {
    AddTodoView({})
}
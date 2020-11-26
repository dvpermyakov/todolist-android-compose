package com.dvpermyakov.todolist.add.ui

import androidx.compose.foundation.layout.Column
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
import com.dvpermyakov.todolist.main.ViewModelFactory

@Composable
fun AddTodoView(
    onBack: () -> Unit,
    viewModel: AddTodoViewModel = viewModel(factory = ViewModelFactory)
) {
    val titleState = remember { mutableStateOf("") }
    val descriptionState = remember { mutableStateOf("") }
    val showSnackBar = remember { mutableStateOf(false) }

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
                    title = titleState.value,
                    description = descriptionState.value
                )
                titleState.value = ""
                descriptionState.value = ""
                showSnackBar.value = true
            }) {
                Icon(
                    asset = Icons.Default.Done
                )
            }
        },
        snackbarHost = {
            if (showSnackBar.value) {
                Snackbar(
                    modifier = Modifier.padding(16.dp),
                    text = { Text(stringResource(R.string.todo_add_new_item_success_title)) },
                    action = {
                        TextButton(
                            onClick = {
                                showSnackBar.value = false
                            }
                        ) {
                            Text(stringResource(R.string.todo_add_new_item_success_action))
                        }
                    }
                )
            }
        }
    ) {
        Column {
            TextField(
                value = titleState.value,
                onValueChange = { value ->
                    titleState.value = value
                },
                modifier = Modifier.padding(8.dp),
                label = { Text(stringResource(R.string.add_todo_title_label)) }
            )
            TextField(
                value = descriptionState.value,
                onValueChange = { value ->
                    descriptionState.value = value
                },
                modifier = Modifier.padding(8.dp),
                label = { Text(stringResource(R.string.add_todo_description_label)) }
            )
        }
    }
}

@Preview
@Composable
fun PreviewAddTodoView() {
    AddTodoView({})
}
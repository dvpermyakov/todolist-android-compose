package com.dvpermyakov.todolist.detaills.ui

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.viewinterop.viewModel
import com.dvpermyakov.todolist.R
import com.dvpermyakov.todolist.detaills.presentation.TodoItemDetailsViewModel
import com.dvpermyakov.todolist.detaills.ui.children.LoadingView
import com.dvpermyakov.todolist.detaills.ui.children.TodoItemDetailsFullscreenView
import com.dvpermyakov.todolist.main.ViewModelFactory

@Composable
fun TodoItemDetails(
    onBack: () -> Unit,
    itemId: String,
    viewModel: TodoItemDetailsViewModel = viewModel(factory = ViewModelFactory)
) {
    val item = viewModel.getItem(itemId).observeAsState(null)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(R.string.todo_item_details_appbar))
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Filled.ArrowBack)
                    }
                },
            )
        }
    ) {
        if (item.value != null) {
            TodoItemDetailsFullscreenView(item.value!!)
        } else {
            LoadingView()
        }
    }
}
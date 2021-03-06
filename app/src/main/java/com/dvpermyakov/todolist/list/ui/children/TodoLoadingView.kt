package com.dvpermyakov.todolist.list.ui.children

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

@Composable
fun TodoLoadingView() {
    Surface(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(
            modifier = Modifier.size(64.dp)
        )
    }
}

@Preview
@Composable
fun PreviewTodoLoadingView() {
    TodoLoadingView()
}
package com.dvpermyakov.todolist.ui.main

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

@Composable
fun TodoAlertDialog(
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        buttons = {
            ButtonsView(onDismiss)
        },
        title = {
            Text(text = "Welcome to todo list!")
        },
        text = {
            Text("You can create your own todo list. Just click on Add button!")
        }
    )
}

@Composable
fun ButtonsView(
    onDismiss: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        horizontalArrangement = Arrangement.End
    ) {
        Button(
            onClick = onDismiss,
            contentPadding = PaddingValues(8.dp)
        ) {
            Text(text = "ok")
        }
    }
}

@Preview
@Composable
fun PreviewTodoAlertDialog() {
    ButtonsView {}
}
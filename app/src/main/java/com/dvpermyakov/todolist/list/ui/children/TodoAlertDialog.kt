package com.dvpermyakov.todolist.list.ui.children

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.dvpermyakov.todolist.R

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
            Text(stringResource(R.string.todo_welcome_dialog_title))
        },
        text = {
            Text(stringResource(R.string.todo_welcome_dialog_subtitle))
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
            Text(stringResource(R.string.todo_welcome_dialog_action))
        }
    }
}

@Preview
@Composable
fun PreviewTodoAlertDialog() {
    ButtonsView {}
}
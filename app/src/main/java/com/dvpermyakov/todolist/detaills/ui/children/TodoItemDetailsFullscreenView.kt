package com.dvpermyakov.todolist.detaills.ui.children

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.dvpermyakov.todolist.R
import com.dvpermyakov.todolist.list.domain.TodoItem

@Composable
fun TodoItemDetailsFullscreenView(
    item: TodoItem
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth().padding(16.dp)
    ) {
        Text(
            text = item.title
        )
        Text(
            text = item.description,
            modifier = Modifier.padding(top = 8.dp)
        )
        Image(
            asset = imageResource(id = R.drawable.ic_cat),
            modifier = Modifier
                .width(256.dp)
                .height(256.dp)
                .clip(RoundedCornerShape(8.dp))
                .padding(top = 8.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview
@Composable
fun PreviewTodoItemDetailsFullscreenView() {
    TodoItemDetailsFullscreenView(
        TodoItem(
            id = "",
            image = 0,
            title = "Need to improve android article about Compose",
            description = "Need not only improve, but rewrite some code as well. Good to do it as soon as possible"
        )
    )
}
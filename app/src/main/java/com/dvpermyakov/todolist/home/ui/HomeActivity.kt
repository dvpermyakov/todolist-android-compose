package com.dvpermyakov.todolist.home.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.platform.setContent
import androidx.lifecycle.ViewModelProvider
import com.dvpermyakov.todolist.home.presentation.HomeViewModel

class HomeActivity : AppCompatActivity() {

    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        setContent {
            MaterialTheme {
                TodoListView(
                    items = viewModel.items,
                    onAddClick = {
                        viewModel.onAddClick()
                    },
                    onItemClick = { item ->
                        viewModel.onTodoItemClick(item)
                    }
                )
            }
        }
    }
}
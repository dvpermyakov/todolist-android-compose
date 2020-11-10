package com.dvpermyakov.todolist.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        return ComposeView(requireContext()).apply {
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

    companion object {
        fun newInstance() = MainFragment()
    }
}
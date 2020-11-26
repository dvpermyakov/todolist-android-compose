package com.dvpermyakov.todolist.list.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dvpermyakov.todolist.R
import com.dvpermyakov.todolist.list.domain.TodoItem
import com.dvpermyakov.todolist.list.domain.TodoRepository
import java.util.concurrent.atomic.AtomicInteger

class TodoRepositoryImpl : TodoRepository {
    private val nextId = AtomicInteger()
    private val items = MutableLiveData<List<TodoItem>>()

    override fun getItems(): LiveData<List<TodoItem>> {
        return items
    }

    override fun addItem(title: String, description: String) {
        val item = TodoItem(
            id = nextId.getAndDecrement().toString(),
            image = R.drawable.ic_cat,
            title = title,
            description = description
        )
        items.value = (items.value ?: emptyList()).toMutableList().apply {
            add(item)
        }
    }

    override fun getItem(id: String): LiveData<TodoItem?> {
        return MutableLiveData<TodoItem?>(items.value?.find { it.id == id })
    }

}
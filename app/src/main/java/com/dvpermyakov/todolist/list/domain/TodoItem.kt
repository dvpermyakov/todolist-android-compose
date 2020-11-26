package com.dvpermyakov.todolist.list.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TodoItem(
    val id: String,
    val image: Int,
    val title: String,
    val description: String
) : Parcelable
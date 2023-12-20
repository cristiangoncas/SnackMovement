package com.cristiangoncas.snackmovement.model.repository.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movement(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @NonNull
    @ColumnInfo(name = "icon_id")
    val iconId: String,
    @NonNull
    @ColumnInfo(name = "resource_id")
    val resourceId: String,
    @NonNull
    @ColumnInfo(name = "name")
    val name: String,
    @NonNull
    @ColumnInfo(name = "description")
    val description: String,
    @NonNull
    @ColumnInfo(name = "difficulty")
    val difficulty: Int,
)

package com.cristiangoncas.snackmovement.model.repository.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Challenge(
    @PrimaryKey val id: Int,
    @NonNull
    @ColumnInfo(name = "image_id")
    val imageId: String,
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

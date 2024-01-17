package com.cristiangoncas.snackmovement.model.repository.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class SnackLog(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @NonNull
    @ColumnInfo(name = "date")
    val date: Date, // TODO: Is Long the best choice?
    @NonNull
    @ColumnInfo(name = "movement_id")
    val movementId: Int,
    @NonNull
    @ColumnInfo(name = "movement_name")
    val movementName: String,
    @NonNull
    @ColumnInfo(name = "movement_difficulty")
    val movementDifficulty: Int,
)

package com.cristiangoncas.snackmovement.framework.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DbExercise(
    @PrimaryKey
    val id: Int,
    val name: String,
    val description: String,
    val difficulty: Int,
    val muscle_group: String,
    val requires_equipment: Boolean
)

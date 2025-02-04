package com.cristiangoncas.snackmovement.framework.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DbGoal(
    @PrimaryKey
    val id: Int,
    val type: Int,
    val goal: Int,
)

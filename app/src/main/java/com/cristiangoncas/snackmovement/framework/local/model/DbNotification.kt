package com.cristiangoncas.snackmovement.framework.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DbNotification(
    @PrimaryKey
    val id: Int,
    val frequency: Int,
    val type: Int,
    val restricted_times: Int
)

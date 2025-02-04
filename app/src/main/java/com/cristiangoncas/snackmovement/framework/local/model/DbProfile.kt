package com.cristiangoncas.snackmovement.framework.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DbProfile(
    @PrimaryKey
    val id: Int,
    val name: String
)

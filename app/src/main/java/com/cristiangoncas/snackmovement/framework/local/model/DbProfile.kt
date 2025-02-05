package com.cristiangoncas.snackmovement.framework.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/** Represents a user profile in the local database */
@Entity(tableName = "Profile")
data class DbProfile(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String
)

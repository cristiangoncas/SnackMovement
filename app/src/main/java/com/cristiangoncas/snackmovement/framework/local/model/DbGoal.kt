package com.cristiangoncas.snackmovement.framework.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/** Represents a user's fitness goal in the local database */
@Entity(tableName = "Goals")
data class DbGoal(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "type")
    val type: Int,
    @ColumnInfo(name = "goal")
    val goal: Int,
)

enum class GoalType(val id: Int) {
    STEPS(0),
    CALORIES(1),
    DISTANCE(2);

    companion object {
        fun fromId(id: Int) = entries.firstOrNull { it.id == id } ?: STEPS
    }
}

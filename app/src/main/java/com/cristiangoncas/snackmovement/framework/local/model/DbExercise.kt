package com.cristiangoncas.snackmovement.framework.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/** Represents an exercise in the local database */
@Entity(tableName = "exercises")
data class DbExercise(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "difficulty")
    val difficulty: Int,
    @ColumnInfo(name = "muscle_group")
    val muscleGroup: String,
    @ColumnInfo(name = "requires_equipment")
    val requiresEquipment: Boolean
)

enum class ExerciseDifficulty(val id: Int) {
    BEGINNER(0),
    INTERMEDIATE(1),
    ADVANCED(2);

    companion object {
        fun fromId(id: Int) = entries.firstOrNull { it.id == id } ?: BEGINNER
    }
}

enum class MuscleGroup(val id: Int) {
    LEGS(0),
    ARMS(1),
    CORE(2),
    BACK(3),
    CHEST(4),
    SHOULDERS(5);

    companion object {
        fun fromId(id: Int) = entries.firstOrNull { it.id == id } ?: LEGS
    }
}

package com.cristiangoncas.snackmovement.domain.models

data class Exercise(
    val name: String,
    val description: String,
    val difficulty: DifficultyLevel,
    val muscleGroups: List<MuscleGroup>,
    val requiresEquipment: Boolean,
)

enum class DifficultyLevel(val id: Int) {
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
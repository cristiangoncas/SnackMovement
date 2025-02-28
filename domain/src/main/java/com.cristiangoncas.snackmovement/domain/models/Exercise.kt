package com.cristiangoncas.snackmovement.domain.models

data class Exercise(
    val id: Int = 0,
    val name: String,
    val description: String,
    val difficulty: DifficultyLevel,
    val muscleGroups: List<MuscleGroup>,
    val requiresEquipment: Boolean,
)

enum class DifficultyLevel(val id: Int, val label: String) {
    BEGINNER(0, "Beginner"),
    INTERMEDIATE(1, "Intermediate"),
    ADVANCED(2, "Advanced");

    companion object {
        fun fromId(id: Int) = entries.firstOrNull { it.id == id } ?: BEGINNER
    }
}

enum class MuscleGroup(val id: Int, val label: String) {
    LEGS(0, "Legs"),
    ARMS(1, "Arms"),
    CORE(2, "Core"),
    BACK(3, "Back"),
    CHEST(4, "Chest"),
    SHOULDERS(5, "Shoulders");

    companion object {
        fun fromId(id: Int) = entries.firstOrNull { it.id == id } ?: LEGS
    }
}
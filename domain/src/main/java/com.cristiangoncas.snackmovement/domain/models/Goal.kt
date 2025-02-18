package com.cristiangoncas.snackmovement.domain.models

data class Goal(
    val id: Int,
    val type: GoalType,
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

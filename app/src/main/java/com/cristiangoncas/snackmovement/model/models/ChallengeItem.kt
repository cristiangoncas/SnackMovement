package com.cristiangoncas.snackmovement.model.models

data class ChallengeItem(
    val id: Int,
    val imageResId: Int,
    val label: String,
    val difficulty: DIFFICULTY,
)

enum class DIFFICULTY(val value: Int) {
    UNDEFINED(0), BEGINNERS(1), INTERMEDIATE(2), ADVANCED(3),
}

fun difficultyFromInt(value: Int): DIFFICULTY {
    return when (value) {
        DIFFICULTY.BEGINNERS.value -> {
            DIFFICULTY.BEGINNERS
        }

        DIFFICULTY.INTERMEDIATE.value -> {
            DIFFICULTY.INTERMEDIATE
        }

        DIFFICULTY.ADVANCED.value -> {
            DIFFICULTY.ADVANCED
        }

        else -> {
            DIFFICULTY.UNDEFINED
        }
    }
}

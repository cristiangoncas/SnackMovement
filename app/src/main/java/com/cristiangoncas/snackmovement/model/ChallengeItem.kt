package com.cristiangoncas.snackmovement.model

data class ChallengeItem(
    val id: Int,
    val imageResId: Int,
    val label: String,
    val difficulty: DIFFICULTY,
)

enum class DIFFICULTY(val difficulty: Int) {
    BEGINNERS(0),
    INTERMEDIATE(1),
    ADVANCED(2),
}

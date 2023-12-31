package com.cristiangoncas.snackmovement.model.models

data class Movement(
    val id: Int,
    val imageId: String,
    val name: String,
    val description: String,
    val difficulty: DIFFICULTY,
) {

    companion object {
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
    }

    enum class DIFFICULTY(val value: Int, val stringValue: String) {
        UNDEFINED(0, "Undefined"),
        BEGINNERS(1, "Beginners"),
        INTERMEDIATE(2, "Intermediate"),
        ADVANCED(3, "Advanced"),
    }
}

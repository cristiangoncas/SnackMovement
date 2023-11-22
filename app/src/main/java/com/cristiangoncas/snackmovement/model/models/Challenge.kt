package com.cristiangoncas.snackmovement.model.models

data class Challenge(
    val id: Int,
    val imageId: String,
    val name: String,
    val description: String,
    val difficulty: DIFFICULTY
)

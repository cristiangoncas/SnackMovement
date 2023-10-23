package com.cristiangoncas.snackmovement.model

data class Challenge(
    val id: Int,
    val imageId: String,
    val name: String,
    val description: String,
    val reps: Int,
)

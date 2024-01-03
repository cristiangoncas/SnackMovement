package com.cristiangoncas.snackmovement.model.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Snack(
    val id: Int = 0,
    @SerialName("movement_id")
    val movementId: Int,
    @SerialName("movement_name")
    val movementName: String,
    @SerialName("movement_difficulty")
    val movementDifficulty: Movement.DIFFICULTY,
)

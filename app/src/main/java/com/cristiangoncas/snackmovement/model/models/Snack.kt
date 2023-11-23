package com.cristiangoncas.snackmovement.model.models

data class Snack(val id: Int, val name: String, val movementId: Int, val movementName: String, val movementDifficulty: Movement.DIFFICULTY)

package com.cristiangoncas.snackmovement.model.models

data class SnackLog(val id: Int, val timestamp: Long, val snackId: Int, val snackName: String, val snackDifficulty: Movement.DIFFICULTY)

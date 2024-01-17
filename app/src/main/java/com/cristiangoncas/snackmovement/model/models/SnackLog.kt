package com.cristiangoncas.snackmovement.model.models

import java.util.Date

data class SnackLog(val id: Int, val date: Date, val snackId: Int, val snackName: String, val snackDifficulty: Movement.DIFFICULTY)

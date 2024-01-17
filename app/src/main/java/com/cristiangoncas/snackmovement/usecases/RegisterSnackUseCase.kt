package com.cristiangoncas.snackmovement.usecases

import com.cristiangoncas.snackmovement.model.models.Snack
import com.cristiangoncas.snackmovement.model.repository.SnacksLogRepository
import java.util.Calendar

interface RegisterSnackUseCase {

    operator fun invoke(snack: Snack)
}

class RegisterSnackUseCaseImpl(
    private val snacksLogRepository: SnacksLogRepository,
) : RegisterSnackUseCase {
    override fun invoke(snack: Snack) {
        snacksLogRepository.insertSnackLog(Calendar.getInstance().time, snack)
    }
}

package com.cristiangoncas.snackmovement.usecases

import com.cristiangoncas.snackmovement.model.models.SnackLog
import com.cristiangoncas.snackmovement.model.repository.SnacksLogRepository
import kotlinx.coroutines.flow.Flow
import java.util.Calendar

interface GetTodaySnacksUseCase {

    operator fun invoke(): Flow<List<SnackLog>>
}

class GetTodaySnacksUseCaseImpl(
    private val snacksLogRepository: SnacksLogRepository,
) : GetTodaySnacksUseCase {

    override fun invoke(): Flow<List<SnackLog>> {
        val today = Calendar.getInstance()
        return snacksLogRepository.getSnackLogsByDate(today.time)
    }
}

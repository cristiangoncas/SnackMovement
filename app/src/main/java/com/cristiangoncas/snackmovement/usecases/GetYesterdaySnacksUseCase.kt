package com.cristiangoncas.snackmovement.usecases

import com.cristiangoncas.snackmovement.model.models.SnackLog
import com.cristiangoncas.snackmovement.model.repository.SnacksLogRepository
import kotlinx.coroutines.flow.Flow
import java.util.Calendar

interface GetYesterdaySnacksUseCase {

    operator fun invoke(): Flow<List<SnackLog>>
}

class GetYesterdaySnacksUseCaseImpl(
    private val snacksLogRepository: SnacksLogRepository,
) : GetYesterdaySnacksUseCase {

    override fun invoke(): Flow<List<SnackLog>> {
        val yesterday = Calendar.getInstance().apply {
            add(Calendar.DAY_OF_YEAR, -1)
        }
        return snacksLogRepository.getSnackLogsByDate(yesterday.time)
    }
}

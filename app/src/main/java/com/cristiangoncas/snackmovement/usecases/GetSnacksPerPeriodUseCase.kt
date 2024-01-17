package com.cristiangoncas.snackmovement.usecases

import com.cristiangoncas.snackmovement.model.models.SnackLog
import com.cristiangoncas.snackmovement.model.repository.SnacksLogRepository
import kotlinx.coroutines.flow.Flow
import java.util.Calendar

interface GetSnacksPerPeriodUseCase {

    operator fun invoke(period: PERIOD): Flow<List<SnackLog>>
}

class GetSnacksPerPeriodUseCaseImpl(
    private val snacksLogRepository: SnacksLogRepository
) : GetSnacksPerPeriodUseCase {

    override fun invoke(period: PERIOD): Flow<List<SnackLog>> {
        val today = Calendar.getInstance()
        val initDay = Calendar.getInstance().apply {
            add(Calendar.DAY_OF_YEAR, -period.days)
        }
        return snacksLogRepository.getAverageSnackLogsByPeriodOfTime(initDay.time, today.time)
    }
}

enum class PERIOD(val days: Int) {
    WEEK(7),
    MONTH(30),
    THREE_MONTHS(90),
    SIX_MONTHS(180),
    YEAR(365),
}

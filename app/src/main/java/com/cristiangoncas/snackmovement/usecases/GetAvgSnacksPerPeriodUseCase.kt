package com.cristiangoncas.snackmovement.usecases

interface GetAvgSnacksPerPeriodUseCase {

    operator fun invoke(period: PERIOD): Int
}

class GetAvgSnacksPerPeriodUseCaseImpl : GetAvgSnacksPerPeriodUseCase {

    override fun invoke(period: PERIOD): Int {
        return 8
    }
}

enum class PERIOD(val days: Int) {
    WEEK(7),
    MONTH(30),
    THREE_MONTHS(90),
    SIX_MONTHS(180),
    YEAR(365),
}

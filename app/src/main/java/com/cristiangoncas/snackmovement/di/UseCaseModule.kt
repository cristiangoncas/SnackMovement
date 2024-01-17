package com.cristiangoncas.snackmovement.di

import com.cristiangoncas.snackmovement.usecases.GetSnacksPerPeriodUseCase
import com.cristiangoncas.snackmovement.usecases.GetSnacksPerPeriodUseCaseImpl
import com.cristiangoncas.snackmovement.usecases.GetCountDownTimerUseCase
import com.cristiangoncas.snackmovement.usecases.GetCountDownTimerUseCaseImpl
import com.cristiangoncas.snackmovement.usecases.GetGoalUseCase
import com.cristiangoncas.snackmovement.usecases.GetGoalUseCaseImpl
import com.cristiangoncas.snackmovement.usecases.GetMovementDetailsUseCase
import com.cristiangoncas.snackmovement.usecases.GetMovementDetailsUseCaseImpl
import com.cristiangoncas.snackmovement.usecases.GetMovementsUseCase
import com.cristiangoncas.snackmovement.usecases.GetMovementsUseCaseImpl
import com.cristiangoncas.snackmovement.usecases.GetStatisticsUseCase
import com.cristiangoncas.snackmovement.usecases.GetStatisticsUseCaseImpl
import com.cristiangoncas.snackmovement.usecases.GetTodaySnacksUseCase
import com.cristiangoncas.snackmovement.usecases.GetTodaySnacksUseCaseImpl
import com.cristiangoncas.snackmovement.usecases.GetTopChallengesUseCase
import com.cristiangoncas.snackmovement.usecases.GetTopChallengesUseCaseImpl
import com.cristiangoncas.snackmovement.usecases.GetYesterdaySnacksUseCase
import com.cristiangoncas.snackmovement.usecases.GetYesterdaySnacksUseCaseImpl
import com.cristiangoncas.snackmovement.usecases.RegisterSnackUseCase
import com.cristiangoncas.snackmovement.usecases.RegisterSnackUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {

    factory<GetTodaySnacksUseCase> { GetTodaySnacksUseCaseImpl(get()) }

    factory<GetYesterdaySnacksUseCase> {
        GetYesterdaySnacksUseCaseImpl(get())
    }

    factory<GetSnacksPerPeriodUseCase> {
        GetSnacksPerPeriodUseCaseImpl(get())
    }

    factory<GetTopChallengesUseCase> {
        GetTopChallengesUseCaseImpl()
    }

    factory<GetGoalUseCase> {
        GetGoalUseCaseImpl()
    }

    factory<GetMovementsUseCase> {
        GetMovementsUseCaseImpl(get())
    }

    factory<GetMovementDetailsUseCase> {
        GetMovementDetailsUseCaseImpl(get())
    }

    factory<GetStatisticsUseCase> {
        GetStatisticsUseCaseImpl()
    }

    factory<GetCountDownTimerUseCase> {
        GetCountDownTimerUseCaseImpl()
    }

    factory<RegisterSnackUseCase> {
        RegisterSnackUseCaseImpl(get())
    }
}

package com.cristiangoncas.snackmovement.di

import com.cristiangoncas.snackmovement.usecases.GetAvgSnacksPerPeriodUseCase
import com.cristiangoncas.snackmovement.usecases.GetAvgSnacksPerPeriodUseCaseImpl
import com.cristiangoncas.snackmovement.usecases.GetChallengeDetailsUseCase
import com.cristiangoncas.snackmovement.usecases.GetChallengeDetailsUseCaseImpl
import com.cristiangoncas.snackmovement.usecases.GetChallengesUseCase
import com.cristiangoncas.snackmovement.usecases.GetChallengesUseCaseImpl
import com.cristiangoncas.snackmovement.usecases.GetGoalUseCase
import com.cristiangoncas.snackmovement.usecases.GetGoalUseCaseImpl
import com.cristiangoncas.snackmovement.usecases.GetStatisticsUseCase
import com.cristiangoncas.snackmovement.usecases.GetStatisticsUseCaseImpl
import com.cristiangoncas.snackmovement.usecases.GetTodaySnacksUseCase
import com.cristiangoncas.snackmovement.usecases.GetTodaySnacksUseCaseImpl
import com.cristiangoncas.snackmovement.usecases.GetTopChallengesUseCase
import com.cristiangoncas.snackmovement.usecases.GetTopChallengesUseCaseImpl
import com.cristiangoncas.snackmovement.usecases.GetYesterdaySnacksUseCase
import com.cristiangoncas.snackmovement.usecases.GetYesterdaySnacksUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {

    factory<GetTodaySnacksUseCase> { GetTodaySnacksUseCaseImpl() }

    factory<GetYesterdaySnacksUseCase> {
        GetYesterdaySnacksUseCaseImpl()
    }

    factory<GetAvgSnacksPerPeriodUseCase> {
        GetAvgSnacksPerPeriodUseCaseImpl()
    }

    factory<GetTopChallengesUseCase> {
        GetTopChallengesUseCaseImpl()
    }

    factory<GetGoalUseCase> {
        GetGoalUseCaseImpl()
    }

    factory<GetChallengesUseCase> {
        GetChallengesUseCaseImpl(get())
    }

    factory<GetChallengeDetailsUseCase> {
        GetChallengeDetailsUseCaseImpl()
    }

    factory<GetStatisticsUseCase> {
        GetStatisticsUseCaseImpl()
    }
}

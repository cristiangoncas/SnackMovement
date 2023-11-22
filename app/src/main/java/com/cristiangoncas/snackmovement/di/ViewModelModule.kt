package com.cristiangoncas.snackmovement.di

import com.cristiangoncas.snackmovement.view.viewmodel.ChallengesViewModelImpl
import com.cristiangoncas.snackmovement.view.viewmodel.HomeViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModelImpl(get(), get(), get(), get()) }
    viewModel { ChallengesViewModelImpl(get(), get()) }
}

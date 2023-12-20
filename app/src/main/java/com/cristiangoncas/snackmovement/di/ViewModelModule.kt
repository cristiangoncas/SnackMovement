package com.cristiangoncas.snackmovement.di

import com.cristiangoncas.snackmovement.view.viewmodel.HomeViewModelImpl
import com.cristiangoncas.snackmovement.view.viewmodel.MovementDetailViewModelImpl
import com.cristiangoncas.snackmovement.view.viewmodel.MovementsViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModelImpl(get(), get(), get(), get()) }
    viewModel { MovementsViewModelImpl(get(), get()) }
    viewModel { MovementDetailViewModelImpl(get()) }
}

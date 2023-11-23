package com.cristiangoncas.snackmovement.di

import com.cristiangoncas.snackmovement.model.repository.MovementRepository
import com.cristiangoncas.snackmovement.model.repository.MovementRepositoryImpl
import com.cristiangoncas.snackmovement.model.repository.local.AppDatabase
import org.koin.dsl.module

val databaseModule = module {
    single {
        AppDatabase.getDatabase(get())
    }

    single {
        val db: AppDatabase = get()
        db.challengeDao()
    }

    single<MovementRepository> {
        MovementRepositoryImpl(get())
    }
}

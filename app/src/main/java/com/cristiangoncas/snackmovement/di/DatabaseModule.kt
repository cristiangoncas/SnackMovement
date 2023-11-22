package com.cristiangoncas.snackmovement.di

import com.cristiangoncas.snackmovement.model.repository.ChallengeRepository
import com.cristiangoncas.snackmovement.model.repository.ChallengeRepositoryImpl
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

    single<ChallengeRepository> {
        ChallengeRepositoryImpl(get())
    }
}

package com.cristiangoncas.snackmovement.di

import com.cristiangoncas.snackmovement.model.models.Movement
import com.cristiangoncas.snackmovement.model.repository.MovementRepository
import com.cristiangoncas.snackmovement.model.repository.MovementRepositoryImpl
import com.cristiangoncas.snackmovement.model.repository.SnacksLogRepository
import com.cristiangoncas.snackmovement.model.repository.SnacksLogRepositoryImpl
import com.cristiangoncas.snackmovement.model.repository.local.AppDatabase
import kotlinx.coroutines.delay
import org.koin.dsl.module

val databaseModule = module {
    single {
        AppDatabase.getDatabase(get())
    }

    single {
        val db: AppDatabase = get()
        db.movementDao()
    }

    single {
        val db: AppDatabase = get()
        db.snackLogDao()
    }

    single<MovementRepository> {
        MovementRepositoryImpl(get())
    }

    single<SnacksLogRepository> {
        SnacksLogRepositoryImpl(get())
    }
}

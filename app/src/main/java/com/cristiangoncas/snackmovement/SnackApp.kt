package com.cristiangoncas.snackmovement

import android.app.Application
import com.cristiangoncas.snackmovement.di.databaseModule
import com.cristiangoncas.snackmovement.di.useCaseModule
import com.cristiangoncas.snackmovement.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class SnackApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@SnackApp)
            modules(viewModelModule, useCaseModule, databaseModule)
        }
    }
}

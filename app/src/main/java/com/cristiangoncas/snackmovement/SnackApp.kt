package com.cristiangoncas.snackmovement

import android.app.Application
import com.cristiangoncas.snackmovement.di.databaseModule
import com.cristiangoncas.snackmovement.di.useCaseModule
import com.cristiangoncas.snackmovement.di.viewModelModule
import com.cristiangoncas.snackmovement.model.models.Movement
import com.cristiangoncas.snackmovement.model.repository.local.AppDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
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

        loadDb()
    }

    fun loadDb() {
        GlobalScope.launch {
            val db = AppDatabase.getDatabase(applicationContext)
            db.movementDao().insertMovement(
                com.cristiangoncas.snackmovement.model.repository.local.entity.Movement(
                    id = 0,
                    iconId = "",
                    resourceId = "imageId",
                    name = "Squat",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    difficulty = Movement.DIFFICULTY.BEGINNERS.value,
                ),
            )
            db.movementDao().insertMovement(
                com.cristiangoncas.snackmovement.model.repository.local.entity.Movement(
                    id = 1,
                    iconId = "",
                    resourceId = "",
                    name = "Push up",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    difficulty = Movement.DIFFICULTY.BEGINNERS.value,
                ),
            )
            db.movementDao().insertMovement(
                com.cristiangoncas.snackmovement.model.repository.local.entity.Movement(
                    id = 2,
                    iconId = "",
                    resourceId = "",
                    name = "Glute bridge",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    difficulty = Movement.DIFFICULTY.BEGINNERS.value,
                ),
            )
            db.movementDao().insertMovement(
                com.cristiangoncas.snackmovement.model.repository.local.entity.Movement(
                    id = 3,
                    iconId = "",
                    resourceId = "",
                    name = "Heel-raise",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    difficulty = Movement.DIFFICULTY.BEGINNERS.value,
                ),
            )
            db.movementDao().insertMovement(
                com.cristiangoncas.snackmovement.model.repository.local.entity.Movement(
                    id = 4,
                    iconId = "",
                    resourceId = "",
                    name = "Burpee",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    difficulty = Movement.DIFFICULTY.INTERMEDIATE.value,
                ),
            )
            db.movementDao().insertMovement(
                com.cristiangoncas.snackmovement.model.repository.local.entity.Movement(
                    id = 5,
                    iconId = "",
                    resourceId = "",
                    name = "Mountain climbers",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    difficulty = Movement.DIFFICULTY.INTERMEDIATE.value,
                ),
            )
            db.movementDao().insertMovement(
                com.cristiangoncas.snackmovement.model.repository.local.entity.Movement(
                    id = 6,
                    iconId = "",
                    resourceId = "",
                    name = "Plank",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    difficulty = Movement.DIFFICULTY.INTERMEDIATE.value,
                ),
            )
            db.movementDao().insertMovement(
                com.cristiangoncas.snackmovement.model.repository.local.entity.Movement(
                    id = 7,
                    iconId = "",
                    resourceId = "",
                    name = "Wall sit",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    difficulty = Movement.DIFFICULTY.INTERMEDIATE.value,
                ),
            )
            db.movementDao().insertMovement(
                com.cristiangoncas.snackmovement.model.repository.local.entity.Movement(
                    id = 8,
                    iconId = "",
                    resourceId = "",
                    name = "Kettlebell swings",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    difficulty = Movement.DIFFICULTY.ADVANCED.value,
                ),
            )
            db.movementDao().insertMovement(
                com.cristiangoncas.snackmovement.model.repository.local.entity.Movement(
                    id = 9,
                    iconId = "",
                    resourceId = "",
                    name = "Bulgarian split squat",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    difficulty = Movement.DIFFICULTY.ADVANCED.value,
                ),
            )
            db.movementDao().insertMovement(
                com.cristiangoncas.snackmovement.model.repository.local.entity.Movement(
                    id = 10,
                    iconId = "",
                    resourceId = "",
                    name = "Pistol squat",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    difficulty = Movement.DIFFICULTY.ADVANCED.value,
                ),
            )
            db.movementDao().insertMovement(
                com.cristiangoncas.snackmovement.model.repository.local.entity.Movement(
                    id = 11,
                    iconId = "",
                    resourceId = "",
                    name = "Pull ups",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    difficulty = Movement.DIFFICULTY.ADVANCED.value,
                ),
            )
        }
    }
}

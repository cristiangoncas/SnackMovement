package com.cristiangoncas.snackmovement.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cristiangoncas.snackmovement.model.models.Movement
import com.cristiangoncas.snackmovement.model.repository.local.AppDatabase
import com.cristiangoncas.snackmovement.usecases.GetMovementsUseCase
import com.cristiangoncas.snackmovement.view.state.MovementsViewState
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.cristiangoncas.snackmovement.model.repository.local.entity.Movement as MovementEntity

class MovementsViewModelImpl(
    private val getMovementsUseCase: GetMovementsUseCase,
    private val db: AppDatabase,
) : MovementsViewModel, ViewModel() {

    private val viewStateLiveData: MutableLiveData<MovementsViewState> = MutableLiveData(
        MovementsViewState(),
    )

    override fun viewState(): LiveData<MovementsViewState> {
        loadMovements()
        return viewStateLiveData
    }

    override fun loadMovements() {
        GlobalScope.launch {
            populateDb()
        }
        viewModelScope.launch {
            getMovementsUseCase.invoke().collect { movements ->
                viewStateLiveData.value?.let { viewState ->
                    viewState.movements = movements
                    viewStateLiveData.postValue(viewState)
                }
            }
        }
    }

    suspend fun populateDb() {
        db.movementDao().insertMovement(
            MovementEntity(
                id = 0,
                imageId = "imageId",
                name = "Squat",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                difficulty = Movement.DIFFICULTY.BEGINNERS.value,
            ),
        )
        delay(150)
        db.movementDao().insertMovement(
            MovementEntity(
                id = 1,
                imageId = "",
                name = "Push up",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                difficulty = Movement.DIFFICULTY.BEGINNERS.value,
            ),
        )
        delay(150)
        db.movementDao().insertMovement(
            MovementEntity(
                id = 2,
                imageId = "",
                name = "Glute bridge",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                difficulty = Movement.DIFFICULTY.BEGINNERS.value,
            ),
        )
        delay(150)
        db.movementDao().insertMovement(
            MovementEntity(
                id = 3,
                imageId = "",
                name = "Heel-raise",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                difficulty = Movement.DIFFICULTY.BEGINNERS.value,
            ),
        )
        delay(150)
        db.movementDao().insertMovement(
            MovementEntity(
                id = 4,
                imageId = "",
                name = "Burpee",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                difficulty = Movement.DIFFICULTY.INTERMEDIATE.value,
            ),
        )
        delay(150)
        db.movementDao().insertMovement(
            MovementEntity(
                id = 5,
                imageId = "",
                name = "Mountain climbers",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                difficulty = Movement.DIFFICULTY.INTERMEDIATE.value,
            ),
        )
        delay(150)
        db.movementDao().insertMovement(
            MovementEntity(
                id = 6,
                imageId = "",
                name = "Plank",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                difficulty = Movement.DIFFICULTY.INTERMEDIATE.value,
            ),
        )
        delay(150)
        db.movementDao().insertMovement(
            MovementEntity(
                id = 7,
                imageId = "",
                name = "Wall sit",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                difficulty = Movement.DIFFICULTY.INTERMEDIATE.value,
            ),
        )
        delay(150)
        db.movementDao().insertMovement(
            MovementEntity(
                id = 8,
                imageId = "",
                name = "Kettlebell swings",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                difficulty = Movement.DIFFICULTY.ADVANCED.value,
            ),
        )
        delay(150)
        db.movementDao().insertMovement(
            MovementEntity(
                id = 9,
                imageId = "",
                name = "Bulgarian split squat",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                difficulty = Movement.DIFFICULTY.ADVANCED.value,
            ),
        )
        delay(150)
        db.movementDao().insertMovement(
            MovementEntity(
                id = 10,
                imageId = "",
                name = "Pistol squat",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                difficulty = Movement.DIFFICULTY.ADVANCED.value,
            ),
        )
        delay(150)
        db.movementDao().insertMovement(
            MovementEntity(
                id = 11,
                imageId = "",
                name = "Pull ups",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                difficulty = Movement.DIFFICULTY.ADVANCED.value,
            ),
        )
    }
}

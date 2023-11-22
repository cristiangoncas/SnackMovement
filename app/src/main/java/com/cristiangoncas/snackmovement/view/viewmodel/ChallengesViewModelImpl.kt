package com.cristiangoncas.snackmovement.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cristiangoncas.snackmovement.model.models.DIFFICULTY
import com.cristiangoncas.snackmovement.model.repository.local.AppDatabase
import com.cristiangoncas.snackmovement.model.repository.local.entity.Challenge
import com.cristiangoncas.snackmovement.usecases.GetChallengesUseCase
import com.cristiangoncas.snackmovement.view.state.ChallengesViewState
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ChallengesViewModelImpl(
    private val getChallengesUseCase: GetChallengesUseCase,
    private val db: AppDatabase,
) : ChallengesViewModel, ViewModel() {

    private val viewStateLiveData: MutableLiveData<ChallengesViewState> = MutableLiveData(
        ChallengesViewState(),
    )

    override fun viewState(): LiveData<ChallengesViewState> {
        loadChallenges()
        return viewStateLiveData
    }

    override fun loadChallenges() {
        GlobalScope.launch {
            populateDb()
        }
        viewModelScope.launch {
            getChallengesUseCase.invoke().collect { challenges ->
                viewStateLiveData.value?.let { viewState ->
                    viewState.challenges = challenges
                    viewStateLiveData.postValue(viewState)
                }
            }
        }
    }

    suspend fun populateDb() {
        db.challengeDao().insertChallenge(
            Challenge(
                id = 0,
                imageId = "imageId",
                name = "Squat",
                description = "description",
                difficulty = DIFFICULTY.BEGINNERS.value,
            ),
        )
        delay(500)
        db.challengeDao().insertChallenge(
            Challenge(
                id = 1,
                imageId = "",
                name = "Push up",
                description = "",
                difficulty = DIFFICULTY.BEGINNERS.value,
            ),
        )
        delay(500)
        db.challengeDao().insertChallenge(
            Challenge(
                id = 2,
                imageId = "",
                name = "Glute bridge",
                description = "",
                difficulty = DIFFICULTY.BEGINNERS.value,
            ),
        )
        delay(500)
        db.challengeDao().insertChallenge(
            Challenge(
                id = 3,
                imageId = "",
                name = "Heel-raise",
                description = "",
                difficulty = DIFFICULTY.BEGINNERS.value,
            ),
        )
        delay(500)
        db.challengeDao().insertChallenge(
            Challenge(
                id = 4,
                imageId = "",
                name = "Burpee",
                description = "",
                difficulty = DIFFICULTY.INTERMEDIATE.value,
            ),
        )
        delay(500)
        db.challengeDao().insertChallenge(
            Challenge(
                id = 5,
                imageId = "",
                name = "Mountain climbers",
                description = "",
                difficulty = DIFFICULTY.INTERMEDIATE.value,
            ),
        )
        delay(500)
        db.challengeDao().insertChallenge(
            Challenge(
                id = 6,
                imageId = "",
                name = "Plank",
                description = "",
                difficulty = DIFFICULTY.INTERMEDIATE.value,
            ),
        )
        delay(500)
        db.challengeDao().insertChallenge(
            Challenge(
                id = 7,
                imageId = "",
                name = "Wall sit",
                description = "",
                difficulty = DIFFICULTY.INTERMEDIATE.value,
            ),
        )
        delay(500)
        db.challengeDao().insertChallenge(
            Challenge(
                id = 8,
                imageId = "",
                name = "Kettlebell swings",
                description = "",
                difficulty = DIFFICULTY.ADVANCED.value,
            ),
        )
        delay(500)
        db.challengeDao().insertChallenge(
            Challenge(
                id = 9,
                imageId = "",
                name = "Bulgarian split squat",
                description = "",
                difficulty = DIFFICULTY.ADVANCED.value,
            ),
        )
        delay(500)
        db.challengeDao().insertChallenge(
            Challenge(
                id = 10,
                imageId = "",
                name = "Pistol squat",
                description = "",
                difficulty = DIFFICULTY.ADVANCED.value,
            ),
        )
        delay(500)
        db.challengeDao().insertChallenge(
            Challenge(
                id = 11,
                imageId = "",
                name = "Pull ups",
                description = "",
                difficulty = DIFFICULTY.ADVANCED.value,
            ),
        )
    }
}

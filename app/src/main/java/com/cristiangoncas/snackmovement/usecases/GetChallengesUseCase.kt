package com.cristiangoncas.snackmovement.usecases

import com.cristiangoncas.snackmovement.model.models.Challenge
import com.cristiangoncas.snackmovement.model.models.DIFFICULTY
import com.cristiangoncas.snackmovement.model.repository.ChallengeRepository
import kotlinx.coroutines.flow.Flow

interface GetChallengesUseCase {
    operator fun invoke(difficulty: DIFFICULTY? = null): Flow<ArrayList<Challenge>>
}

class GetChallengesUseCaseImpl(
    private val challengeRepository: ChallengeRepository,
) : GetChallengesUseCase {

    override fun invoke(difficulty: DIFFICULTY?): Flow<ArrayList<Challenge>> {
        if (difficulty != null) {
            return challengeRepository.getAllChallenges()
        } else {
            return challengeRepository.getAllChallenges()
        }
    }
}

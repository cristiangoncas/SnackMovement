package com.cristiangoncas.snackmovement.usecases

import com.cristiangoncas.snackmovement.model.models.Movement
import com.cristiangoncas.snackmovement.model.models.DIFFICULTY
import com.cristiangoncas.snackmovement.model.repository.MovementRepository
import kotlinx.coroutines.flow.Flow

interface GetChallengesUseCase {
    operator fun invoke(difficulty: DIFFICULTY? = null): Flow<ArrayList<Movement>>
}

class GetChallengesUseCaseImpl(
    private val movementRepository: MovementRepository,
) : GetChallengesUseCase {

    override fun invoke(difficulty: DIFFICULTY?): Flow<ArrayList<Movement>> {
        if (difficulty != null) {
            return movementRepository.getAllMovement()
        } else {
            return movementRepository.getAllMovement()
        }
    }
}

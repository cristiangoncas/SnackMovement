package com.cristiangoncas.snackmovement.usecases

import com.cristiangoncas.snackmovement.model.models.Movement
import com.cristiangoncas.snackmovement.model.repository.MovementRepository
import kotlinx.coroutines.flow.Flow

interface GetMovementsUseCase {
    operator fun invoke(difficulty: Movement.DIFFICULTY? = null): Flow<ArrayList<Movement>>
}

class GetMovementsUseCaseImpl(
    private val movementRepository: MovementRepository,
) : GetMovementsUseCase {

    override fun invoke(difficulty: Movement.DIFFICULTY?): Flow<ArrayList<Movement>> {
        if (difficulty != null) {
            return movementRepository.getAllMovement()
        } else {
            return movementRepository.getAllMovement()
        }
    }
}

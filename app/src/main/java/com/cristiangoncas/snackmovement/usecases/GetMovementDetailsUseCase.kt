package com.cristiangoncas.snackmovement.usecases

import com.cristiangoncas.snackmovement.model.models.Movement
import com.cristiangoncas.snackmovement.model.repository.MovementRepository
import kotlinx.coroutines.flow.Flow

interface GetMovementDetailsUseCase {

    operator fun invoke(movementId: Int): Flow<Movement>
}

class GetMovementDetailsUseCaseImpl(
    private val movementRepository: MovementRepository
) : GetMovementDetailsUseCase {

    override fun invoke(movementId: Int): Flow<Movement> {
        if (movementId > 0) {
            return movementRepository.getMovementById(movementId)
        } else {
            throw Exception("Movement ID must be greater than 0")
        }
    }
}

package com.cristiangoncas.snackmovement.model.repository

import com.cristiangoncas.snackmovement.model.models.Movement
import com.cristiangoncas.snackmovement.model.repository.local.queries.MovementDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface MovementRepository {

    fun getAllMovement(): Flow<ArrayList<Movement>>

    fun getMovementsByDifficulty(difficulty: Movement.DIFFICULTY): Flow<ArrayList<Movement>>
}

class MovementRepositoryImpl(
    private val movementDao: MovementDao,
) : MovementRepository {
    override fun getAllMovement(): Flow<ArrayList<Movement>> {
        return movementDao.getAllMovements()
            .map { movements ->
                val movementList = ArrayList<Movement>(movements.size)
                movements.mapTo(movementList) { movement ->
                    Movement(
                        movement.id,
                        movement.imageId,
                        movement.name,
                        movement.description,
                        Movement.difficultyFromInt(movement.difficulty),
                    )
                }
                movementList
            }
    }

    override fun getMovementsByDifficulty(difficulty: Movement.DIFFICULTY): Flow<ArrayList<Movement>> {
        return movementDao.getMovementsByDifficulty(difficulty.value)
            .map { movements ->
                val movementList = ArrayList<Movement>(movements.size)
                movements.mapTo(movementList) { movement ->
                    Movement(
                        movement.id,
                        movement.imageId,
                        movement.name,
                        movement.description,
                        Movement.difficultyFromInt(movement.difficulty),
                    )
                }
                movementList
            }
    }
}

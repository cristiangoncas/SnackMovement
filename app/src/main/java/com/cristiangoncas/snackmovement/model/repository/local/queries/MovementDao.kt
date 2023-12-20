package com.cristiangoncas.snackmovement.model.repository.local.queries

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cristiangoncas.snackmovement.model.repository.local.entity.Movement
import kotlinx.coroutines.flow.Flow

@Dao
interface MovementDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMovement(movement: Movement)

    @Query("SELECT * FROM Movement ORDER BY id ASC")
    fun getAllMovements(): Flow<List<Movement>>

    @Query("SELECT * FROM Movement WHERE difficulty = :difficulty ORDER BY id ASC")
    fun getMovementsByDifficulty(difficulty: Int): Flow<List<Movement>>

    @Query("SELECT * FROM Movement WHERE id = :movementId")
    fun getMovementById(movementId: Int): Flow<Movement>
}

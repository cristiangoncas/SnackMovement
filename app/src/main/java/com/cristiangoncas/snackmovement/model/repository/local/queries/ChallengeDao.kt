package com.cristiangoncas.snackmovement.model.repository.local.queries

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cristiangoncas.snackmovement.model.repository.local.entity.Challenge
import kotlinx.coroutines.flow.Flow

@Dao
interface ChallengeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertChallenge(challenge: Challenge)

    @Query("SELECT * FROM Challenge ORDER BY id ASC")
    fun getAll(): Flow<List<Challenge>>
}

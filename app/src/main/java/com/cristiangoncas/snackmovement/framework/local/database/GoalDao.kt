package com.cristiangoncas.snackmovement.framework.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.cristiangoncas.snackmovement.framework.local.model.DbGoal

@Dao
interface GoalDao {

    @Insert
    fun insertGoal(goal: DbGoal)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateGoal(goal: DbGoal)

    @Query("SELECT * FROM Goals WHERE type = :type")
    fun getGoalByType(type: Int): DbGoal
}

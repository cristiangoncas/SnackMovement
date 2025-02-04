package com.cristiangoncas.snackmovement.framework.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.cristiangoncas.snackmovement.framework.local.model.DbGoal

@Dao
interface GoalDao {

    @Insert
    fun insertGoal(goal: DbGoal)

    @Update
    fun updateGoal(goal: DbGoal)

    @Query("SELECT * FROM DbGoal WHERE id = :type")
    fun getGoalByType(type: Int): DbGoal
}

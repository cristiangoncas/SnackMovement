package com.cristiangoncas.snackmovement.framework.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.cristiangoncas.snackmovement.framework.local.model.DbExercise

@Dao
interface ExerciseDao {

    @Insert
    fun insertExercise(exercise: DbExercise)

    @Query("SELECT * FROM Exercises")
    fun getAllExercises(): List<DbExercise>


    @Query("SELECT * FROM Exercises WHERE id = :id")
    fun getExerciseById(id: Int): DbExercise

}

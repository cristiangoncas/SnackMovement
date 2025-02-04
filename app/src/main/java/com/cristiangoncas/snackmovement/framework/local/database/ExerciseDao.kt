package com.cristiangoncas.snackmovement.framework.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.cristiangoncas.snackmovement.framework.local.model.DbExercise

@Dao
interface ExerciseDao {

    @Insert
    fun insertExercise(exercise: DbExercise)

    @Query("SELECT * FROM DbExercise")
    fun getAllExercises(): List<DbExercise>


    @Query("SELECT * FROM DbExercise WHERE id = :id")
    fun getExerciseById(id: Int): DbExercise

}

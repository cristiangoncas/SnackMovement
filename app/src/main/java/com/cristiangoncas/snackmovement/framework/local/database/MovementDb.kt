package com.cristiangoncas.snackmovement.framework.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.cristiangoncas.snackmovement.framework.local.model.DbExercise
import com.cristiangoncas.snackmovement.framework.local.model.DbGoal
import com.cristiangoncas.snackmovement.framework.local.model.DbNotification
import com.cristiangoncas.snackmovement.framework.local.model.DbProfile

@Database(entities = [DbExercise::class, DbGoal::class, DbNotification::class, DbProfile::class], version = 1, exportSchema = false)
abstract class MovementDb : RoomDatabase() {

    companion object {
        private const val DATABASE_NAME = "movement.db"

        @Volatile
        var INSTANCE: MovementDb? = null

        fun getInstance(context: Context): MovementDb {
            return INSTANCE ?: synchronized(this) {
                val instance = databaseBuilder(
                    context,
                    MovementDb::class.java,
                    DATABASE_NAME
                ).build()

                INSTANCE = instance

                instance
            }
        }
    }
}

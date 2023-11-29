package com.cristiangoncas.snackmovement.model.repository.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cristiangoncas.snackmovement.model.repository.local.entity.Movement
import com.cristiangoncas.snackmovement.model.repository.local.entity.SnackLog
import com.cristiangoncas.snackmovement.model.repository.local.queries.MovementDao
import com.cristiangoncas.snackmovement.model.repository.local.queries.SnacksLogDao

@Database(entities = [Movement::class, SnackLog::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun movementDao(): MovementDao

    abstract fun snackLogDao(): SnacksLogDao

    companion object {

        @Volatile
        var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "snack_database.db",
                )
//                    .createFromAsset("database/default.db")
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}

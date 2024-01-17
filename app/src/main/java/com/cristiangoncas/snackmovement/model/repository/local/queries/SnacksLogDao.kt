package com.cristiangoncas.snackmovement.model.repository.local.queries

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.cristiangoncas.snackmovement.model.repository.local.entity.SnackLog
import kotlinx.coroutines.flow.Flow
import java.util.Date

@Dao
interface SnacksLogDao {

    @Insert
    fun insertSnackLog(snackLog: SnackLog)

    @Query("SELECT * FROM SnackLog ORDER BY id ASC")
    fun getAllSnackLogs(): Flow<List<SnackLog>>

    @Query("SELECT * FROM SnackLog WHERE movement_difficulty IN (:difficulties)")
    fun getSnackLogsByDifficulty(difficulties: Array<Int>): Flow<List<SnackLog>>

    @Query("SELECT * FROM SnackLog WHERE date >= :startDate AND date <= :endDate")
    fun getSnackLogsByDate(startDate: Long, endDate: Long): Flow<List<SnackLog>>
}

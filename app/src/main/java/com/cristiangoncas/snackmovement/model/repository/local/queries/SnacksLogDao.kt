package com.cristiangoncas.snackmovement.model.repository.local.queries

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.cristiangoncas.snackmovement.model.models.Snack
import com.cristiangoncas.snackmovement.model.repository.local.entity.SnackLog
import kotlinx.coroutines.flow.Flow

@Dao
interface SnacksLogDao {

    @Insert
    fun insertSnackLog(snackLog: SnackLog)

    @Query("SELECT * FROM SnackLog ORDER BY id ASC")
    fun getAllSnackLogs(): Flow<List<SnackLog>>

    @Query("SELECT * FROM SnackLog WHERE movement_difficulty IN (:difficulties)")
    fun getSnackLogsByDate(difficulties: Array<Int>): Flow<List<SnackLog>>

    @Query("SELECT * FROM SnackLog WHERE timestamp >= (:timestamp)")
    fun getSnackLogsByDate(timestamp: Long): Flow<List<SnackLog>>
}

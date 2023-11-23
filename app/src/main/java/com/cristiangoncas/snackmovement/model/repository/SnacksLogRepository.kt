package com.cristiangoncas.snackmovement.model.repository

import com.cristiangoncas.snackmovement.model.models.Movement
import com.cristiangoncas.snackmovement.model.models.Snack
import com.cristiangoncas.snackmovement.model.models.SnackLog
import com.cristiangoncas.snackmovement.model.repository.local.queries.SnacksLogDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.cristiangoncas.snackmovement.model.repository.local.entity.SnackLog as SnackLogEntity

interface SnacksLogRepository {

    fun insertSnackLog(timestamp: Long, snack: Snack)

    fun getAllSnackLogs(): Flow<List<SnackLog>>

    fun getSnackLogsByDifficulty(difficulties: Array<Movement.DIFFICULTY>): Flow<List<SnackLog>>

    fun getSnackLogsByDate(timestamp: Long): Flow<List<SnackLog>>
}

class SnacksLogRepositoryImpl(
    private val snacksLogDao: SnacksLogDao,
) : SnacksLogRepository {
    override fun insertSnackLog(timestamp: Long, snack: Snack) {
        snacksLogDao.insertSnackLog(
            SnackLogEntity(
                timestamp = timestamp,
                movementId = snack.movementId,
                movementName = snack.movementName,
                movementDifficulty = snack.movementDifficulty.value,
            ),
        )
    }

    override fun getAllSnackLogs(): Flow<List<SnackLog>> {
        return snacksLogDao.getAllSnackLogs()
            .map { snacks ->
                val snackList = ArrayList<SnackLog>(snacks.size)
                snacks.mapTo(snackList) { snack ->
                    SnackLog(
                        id = snack.id,
                        timestamp = snack.timestamp,
                        snackId = snack.movementId,
                        snackName = snack.movementName,
                        snackDifficulty = Movement.difficultyFromInt(snack.movementDifficulty),
                    )
                }
                snackList
            }
    }

    override fun getSnackLogsByDifficulty(difficulties: Array<Movement.DIFFICULTY>): Flow<List<SnackLog>> {
        val difficultiesInt = difficulties.map { it.value }.toTypedArray()
        return snacksLogDao.getSnackLogsByDate(difficultiesInt)
            .map { snacks ->
                val snackList = ArrayList<SnackLog>(snacks.size)
                snacks.mapTo(snackList) { snack ->
                    SnackLog(
                        id = snack.id,
                        timestamp = snack.timestamp,
                        snackId = snack.movementId,
                        snackName = snack.movementName,
                        snackDifficulty = Movement.difficultyFromInt(snack.movementDifficulty),
                    )
                }
                snackList
            }
    }

    override fun getSnackLogsByDate(timestamp: Long): Flow<List<SnackLog>> {
        return snacksLogDao.getSnackLogsByDate(timestamp)
            .map { snacks ->
                val snackList = ArrayList<SnackLog>(snacks.size)
                snacks.mapTo(snackList) { snack ->
                    SnackLog(
                        id = snack.id,
                        timestamp = snack.timestamp,
                        snackId = snack.movementId,
                        snackName = snack.movementName,
                        snackDifficulty = Movement.difficultyFromInt(snack.movementDifficulty),
                    )
                }
                snackList
            }
    }
}

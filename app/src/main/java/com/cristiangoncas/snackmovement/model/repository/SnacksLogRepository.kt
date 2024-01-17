package com.cristiangoncas.snackmovement.model.repository

import com.cristiangoncas.snackmovement.model.models.Movement
import com.cristiangoncas.snackmovement.model.models.Snack
import com.cristiangoncas.snackmovement.model.models.SnackLog
import com.cristiangoncas.snackmovement.model.repository.local.getEndOfDayInMillis
import com.cristiangoncas.snackmovement.model.repository.local.getStartOfDayInMillis
import com.cristiangoncas.snackmovement.model.repository.local.queries.SnacksLogDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.Date
import com.cristiangoncas.snackmovement.model.repository.local.entity.SnackLog as SnackLogEntity

interface SnacksLogRepository {

    fun insertSnackLog(date: Date, snack: Snack)

    fun getAllSnackLogs(): Flow<List<SnackLog>>

    fun getSnackLogsByDifficulty(difficulties: Array<Movement.DIFFICULTY>): Flow<List<SnackLog>>

    fun getSnackLogsByDate(date: Date): Flow<List<SnackLog>>

    fun getAverageSnackLogsByPeriodOfTime(initDate: Date, lastDate: Date): Flow<List<SnackLog>>
}

class SnacksLogRepositoryImpl(
    private val snacksLogDao: SnacksLogDao,
) : SnacksLogRepository {
    override fun insertSnackLog(date: Date, snack: Snack) {
        snacksLogDao.insertSnackLog(
            SnackLogEntity(
                date = date,
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
                        date = snack.date,
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
        return snacksLogDao.getSnackLogsByDifficulty(difficultiesInt)
            .map { snacks ->
                val snackList = ArrayList<SnackLog>(snacks.size)
                snacks.mapTo(snackList) { snack ->
                    SnackLog(
                        id = snack.id,
                        date = snack.date,
                        snackId = snack.movementId,
                        snackName = snack.movementName,
                        snackDifficulty = Movement.difficultyFromInt(snack.movementDifficulty),
                    )
                }
                snackList
            }
    }

    override fun getSnackLogsByDate(date: Date): Flow<List<SnackLog>> {
        return snacksLogDao.getSnackLogsByDate(
            date.getStartOfDayInMillis(),
            date.getEndOfDayInMillis(),
        )
            .map { snacks ->
                val snackList = ArrayList<SnackLog>(snacks.size)
                snacks.mapTo(snackList) { snack ->
                    SnackLog(
                        id = snack.id,
                        date = snack.date,
                        snackId = snack.movementId,
                        snackName = snack.movementName,
                        snackDifficulty = Movement.difficultyFromInt(snack.movementDifficulty),
                    )
                }
                snackList
            }
    }

    override fun getAverageSnackLogsByPeriodOfTime(
        initDate: Date,
        lastDate: Date
    ): Flow<List<SnackLog>> {
        return snacksLogDao.getSnackLogsByDate(
            initDate.getStartOfDayInMillis(),
            lastDate.getEndOfDayInMillis(),
        )
            .map { snacks ->
                val snackList = ArrayList<SnackLog>(snacks.size)
                snacks.mapTo(snackList) { snack ->
                    SnackLog(
                        id = snack.id,
                        date = snack.date,
                        snackId = snack.movementId,
                        snackName = snack.movementName,
                        snackDifficulty = Movement.difficultyFromInt(snack.movementDifficulty),
                    )
                }
                snackList
            }
    }
}

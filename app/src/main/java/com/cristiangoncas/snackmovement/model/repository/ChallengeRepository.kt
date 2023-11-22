package com.cristiangoncas.snackmovement.model.repository

import com.cristiangoncas.snackmovement.model.models.Challenge
import com.cristiangoncas.snackmovement.model.models.difficultyFromInt
import com.cristiangoncas.snackmovement.model.repository.local.queries.ChallengeDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface ChallengeRepository {

    fun getAllChallenges(): Flow<ArrayList<Challenge>>
}

class ChallengeRepositoryImpl(
    private val challengeDao: ChallengeDao,
) : ChallengeRepository {
    override fun getAllChallenges(): Flow<ArrayList<Challenge>> {
        return challengeDao.getAll()
            .map { challenges ->
                val challengeList = ArrayList<Challenge>(challenges.size)
                challenges.mapTo(challengeList) { challenge ->
                    Challenge(
                        challenge.id,
                        challenge.imageId,
                        challenge.name,
                        challenge.description,
                        difficultyFromInt(challenge.difficulty),
                    )
                }
                challengeList
            }
    }
}

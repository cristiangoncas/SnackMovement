package com.cristiangoncas.snackmovement.usecases

import com.cristiangoncas.snackmovement.model.ChallengeItem
import com.cristiangoncas.snackmovement.model.DIFFICULTY

interface GetChallengesUseCase {
    operator fun invoke(difficulty: DIFFICULTY? = null): ArrayList<ChallengeItem>
}

class GetChallengesUseCaseImpl : GetChallengesUseCase {

    override fun invoke(difficulty: DIFFICULTY?): ArrayList<ChallengeItem> {
        if (difficulty != null) {
            return when (difficulty) {
                DIFFICULTY.BEGINNERS -> {
                    arrayListOf(
                        ChallengeItem(0, 101, "Push-up", DIFFICULTY.BEGINNERS),
                        ChallengeItem(3, 101, "Squat", DIFFICULTY.BEGINNERS),
                    )
                }

                DIFFICULTY.INTERMEDIATE -> {
                    arrayListOf(
                        ChallengeItem(1, 101, "Plank", DIFFICULTY.INTERMEDIATE),
                        ChallengeItem(5, 101, "Wall sit", DIFFICULTY.INTERMEDIATE),
                    )
                }

                DIFFICULTY.ADVANCED -> {
                    arrayListOf(
                        ChallengeItem(2, 101, "Pull-up", DIFFICULTY.ADVANCED),
                        ChallengeItem(4, 101, "Burpees", DIFFICULTY.ADVANCED),
                    )
                }
            }
        } else {
            return arrayListOf(
                ChallengeItem(0, 101, "Push-up", DIFFICULTY.BEGINNERS),
                ChallengeItem(1, 101, "Plank", DIFFICULTY.INTERMEDIATE),
                ChallengeItem(5, 101, "Wall sit", DIFFICULTY.INTERMEDIATE),
                ChallengeItem(2, 101, "Pull-up", DIFFICULTY.ADVANCED),
                ChallengeItem(4, 101, "Burpees", DIFFICULTY.ADVANCED),
                ChallengeItem(3, 101, "Squat", DIFFICULTY.BEGINNERS),
            )
        }
    }
}

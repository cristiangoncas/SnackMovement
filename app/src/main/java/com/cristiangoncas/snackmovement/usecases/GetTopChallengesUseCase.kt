package com.cristiangoncas.snackmovement.usecases

import com.cristiangoncas.snackmovement.model.models.Movement
import com.cristiangoncas.snackmovement.model.models.DIFFICULTY

interface GetTopChallengesUseCase {

    operator fun invoke(): ArrayList<Movement>
}

class GetTopChallengesUseCaseImpl : GetTopChallengesUseCase {
    override fun invoke(): ArrayList<Movement> {
        return arrayListOf(
            Movement(
                id = 0,
                imageId = "id0",
                name = "Challenge 1",
                description = "Description",
                difficulty = DIFFICULTY.BEGINNERS
            ),
            Movement(
                id = 1,
                imageId = "id1",
                name = "Challenge 2",
                description = "Description",
                difficulty = DIFFICULTY.BEGINNERS
            ),
            Movement(
                id = 2,
                imageId = "id2",
                name = "Challenge 3",
                description = "Description",
                difficulty = DIFFICULTY.INTERMEDIATE
            ),
            Movement(
                id = 3,
                imageId = "id3",
                name = "Challenge 4",
                description = "Description",
                difficulty = DIFFICULTY.INTERMEDIATE
            ),
            Movement(
                id = 4,
                imageId = "id4",
                name = "Challenge 5",
                description = "Description",
                difficulty = DIFFICULTY.ADVANCED
            ),
        )
    }
}

package com.cristiangoncas.snackmovement.usecases

interface GetGoalUseCase {

    operator fun invoke(): Int
}

class GetGoalUseCaseImpl : GetGoalUseCase {

    override fun invoke(): Int {
        return 10
    }
}

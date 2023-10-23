package com.cristiangoncas.snackmovement.usecases

interface GetTodaySnacksUseCase {

    operator fun invoke(): Int
}

class GetTodaySnacksUseCaseImpl : GetTodaySnacksUseCase {

    override fun invoke(): Int {
        return 9
    }
}

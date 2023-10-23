package com.cristiangoncas.snackmovement.usecases

interface GetYesterdaySnacksUseCase {

    operator fun invoke(): Int
}

class GetYesterdaySnacksUseCaseImpl : GetYesterdaySnacksUseCase {

    override fun invoke(): Int {
        return 3
    }
}

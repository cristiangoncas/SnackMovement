package com.cristiangoncas.snackmovement.usecases

import com.cristiangoncas.snackmovement.model.Group

interface GetGroupsUseCase {

    operator fun invoke(): List<Group>
}

class GetGroupsUseCaseImpl : GetGroupsUseCase {
    override fun invoke(): ArrayList<Group> {
        return arrayListOf(
            Group(name = "Group 1"),
            Group(name = "Group 2"),
            Group(name = "Group 3"),
            Group(name = "Group 4"),
            Group(name = "Group 5"),
        )
    }
}

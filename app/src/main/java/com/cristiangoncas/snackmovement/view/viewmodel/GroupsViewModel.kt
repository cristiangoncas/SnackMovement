package com.cristiangoncas.snackmovement.view.viewmodel

import androidx.lifecycle.LiveData
import com.cristiangoncas.snackmovement.view.state.GroupsViewState

interface GroupsViewModel {

    fun viewState(): LiveData<GroupsViewState>
    fun loadGroups()
}

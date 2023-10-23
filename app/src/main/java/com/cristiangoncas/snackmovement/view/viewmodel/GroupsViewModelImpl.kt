package com.cristiangoncas.snackmovement.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cristiangoncas.snackmovement.usecases.GetGroupsUseCaseImpl
import com.cristiangoncas.snackmovement.view.state.GroupsViewState

class GroupsViewModelImpl : GroupsViewModel, ViewModel() {

    private val viewStateLiveData: MutableLiveData<GroupsViewState> = MutableLiveData()

    override fun viewState(): LiveData<GroupsViewState> {
        loadGroups()
        return viewStateLiveData
    }

    override fun loadGroups() {
        val useCase = GetGroupsUseCaseImpl()
        viewStateLiveData.postValue(GroupsViewState(useCase.invoke()))
    }
}

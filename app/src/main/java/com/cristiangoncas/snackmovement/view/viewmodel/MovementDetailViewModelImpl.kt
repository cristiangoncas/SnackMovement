package com.cristiangoncas.snackmovement.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cristiangoncas.snackmovement.usecases.GetMovementDetailsUseCase
import com.cristiangoncas.snackmovement.view.state.MovementDetailViewState
import kotlinx.coroutines.launch

class MovementDetailViewModelImpl(
    private val getMovementUseCase: GetMovementDetailsUseCase,
) : MovementDetailViewModel, ViewModel() {

    private val viewStateLiveData: MutableLiveData<MovementDetailViewState> = MutableLiveData(
        MovementDetailViewState(),
    )

    override fun viewState(): LiveData<MovementDetailViewState> {
        return viewStateLiveData
    }

    override fun fetchMovementById(movementId: Int) {
        viewModelScope.launch {
            getMovementUseCase.invoke(movementId).collect { movement ->
                viewStateLiveData.value?.let { viewState ->
                    viewState.movement = movement
                    viewStateLiveData.postValue(viewState)
                }
            }
        }
    }
}

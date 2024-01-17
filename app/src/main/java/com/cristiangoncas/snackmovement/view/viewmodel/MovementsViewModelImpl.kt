package com.cristiangoncas.snackmovement.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cristiangoncas.snackmovement.model.models.Movement
import com.cristiangoncas.snackmovement.model.repository.local.AppDatabase
import com.cristiangoncas.snackmovement.usecases.GetMovementsUseCase
import com.cristiangoncas.snackmovement.view.state.MovementsViewState
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.cristiangoncas.snackmovement.model.repository.local.entity.Movement as MovementEntity

class MovementsViewModelImpl(
    private val getMovementsUseCase: GetMovementsUseCase,
    private val db: AppDatabase,
) : MovementsViewModel, ViewModel() {

    private val viewStateLiveData: MutableLiveData<MovementsViewState> = MutableLiveData(
        MovementsViewState(),
    )

    override fun viewState(): LiveData<MovementsViewState> {
        loadMovements()
        return viewStateLiveData
    }

    override fun loadMovements() {
        viewModelScope.launch {
            getMovementsUseCase.invoke().collect { movements ->
                viewStateLiveData.value?.let { viewState ->
                    viewState.movements = movements
                    viewStateLiveData.postValue(viewState)
                }
            }
        }
    }
}

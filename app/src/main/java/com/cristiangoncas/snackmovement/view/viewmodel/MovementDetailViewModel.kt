package com.cristiangoncas.snackmovement.view.viewmodel

import androidx.lifecycle.LiveData
import com.cristiangoncas.snackmovement.view.state.MovementDetailViewState

interface MovementDetailViewModel {

    fun viewState(): LiveData<MovementDetailViewState>

    fun fetchMovementById(movementId: Int)
}

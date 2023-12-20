package com.cristiangoncas.snackmovement.view.viewmodel

import androidx.lifecycle.LiveData
import com.cristiangoncas.snackmovement.view.state.MovementsViewState

interface MovementsViewModel {

    fun viewState(): LiveData<MovementsViewState>

    fun loadMovements()
}

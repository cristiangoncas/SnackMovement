package com.cristiangoncas.snackmovement.view.viewmodel

import androidx.lifecycle.LiveData
import com.cristiangoncas.snackmovement.model.models.Snack
import com.cristiangoncas.snackmovement.view.state.SnackInProgressViewState

interface SnackInProgressViewModel {

    fun viewState(): LiveData<SnackInProgressViewState>

    fun setSnack(snack: Snack)

    fun markAsDone()
}

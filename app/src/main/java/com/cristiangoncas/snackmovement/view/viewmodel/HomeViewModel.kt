package com.cristiangoncas.snackmovement.view.viewmodel

import androidx.lifecycle.LiveData
import com.cristiangoncas.snackmovement.view.state.HomeViewState

interface HomeViewModel {

    fun viewState(): LiveData<HomeViewState>

    fun loadHome()
}

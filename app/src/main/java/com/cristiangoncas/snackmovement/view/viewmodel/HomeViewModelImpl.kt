package com.cristiangoncas.snackmovement.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cristiangoncas.snackmovement.usecases.GetAvgSnacksPerPeriodUseCaseImpl
import com.cristiangoncas.snackmovement.usecases.GetTodaySnacksUseCaseImpl
import com.cristiangoncas.snackmovement.usecases.GetTopChallengesUseCaseImpl
import com.cristiangoncas.snackmovement.usecases.GetYesterdaySnacksUseCaseImpl
import com.cristiangoncas.snackmovement.usecases.PERIOD
import com.cristiangoncas.snackmovement.view.state.HomeViewState
import kotlinx.coroutines.launch

class HomeViewModelImpl : HomeViewModel, ViewModel() {

    private val viewStateLiveData: MutableLiveData<HomeViewState> = MutableLiveData(HomeViewState())
    override fun viewState(): LiveData<HomeViewState> {
        loadHome()
        return viewStateLiveData
    }

    override fun loadHome() {
        viewModelScope.launch {
            val today = GetTodaySnacksUseCaseImpl().invoke()
            viewStateLiveData.value?.let { viewState ->
                viewState.todaySnackCount = today
                viewStateLiveData.postValue(viewState)
            }
        }
        viewModelScope.launch {
            val yesterday = GetYesterdaySnacksUseCaseImpl().invoke()
            viewStateLiveData.value?.let { viewState ->
                viewState.yesterdaySnackCount = yesterday
                viewStateLiveData.postValue(viewState)
            }
        }
        viewModelScope.launch {
            val avg = GetAvgSnacksPerPeriodUseCaseImpl().invoke(PERIOD.MONTH)
            viewStateLiveData.value?.let { viewState ->
                viewState.averageSnackCount = avg
                viewStateLiveData.postValue(viewState)
            }
        }
        viewModelScope.launch {
            val top = GetTopChallengesUseCaseImpl().invoke()
            viewStateLiveData.value?.let { viewState ->
                viewState.topList = top
                viewStateLiveData.postValue(viewState)
            }
        }
    }
}

package com.cristiangoncas.snackmovement.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cristiangoncas.snackmovement.model.models.SnackLog
import com.cristiangoncas.snackmovement.usecases.GetSnacksPerPeriodUseCase
import com.cristiangoncas.snackmovement.usecases.GetTodaySnacksUseCase
import com.cristiangoncas.snackmovement.usecases.GetTopChallengesUseCase
import com.cristiangoncas.snackmovement.usecases.GetYesterdaySnacksUseCase
import com.cristiangoncas.snackmovement.usecases.PERIOD
import com.cristiangoncas.snackmovement.view.state.HomeViewState
import kotlinx.coroutines.launch

class HomeViewModelImpl(
    private val getTodaySnacksUseCase: GetTodaySnacksUseCase,
    private val getYesterdaySnacksUseCase: GetYesterdaySnacksUseCase,
    private val getSnacksPerPeriodUseCase: GetSnacksPerPeriodUseCase,
    private val getSnackLog: GetTopChallengesUseCase,
) : HomeViewModel, ViewModel() {

    private val viewStateLiveData: MutableLiveData<HomeViewState> = MutableLiveData(HomeViewState())
    override fun viewState(): LiveData<HomeViewState> {
        loadHome()
        return viewStateLiveData
    }

    override fun loadHome() {
        viewModelScope.launch {
            getTodaySnacksUseCase.invoke().collect {
                viewStateLiveData.value?.let { viewState ->
                    viewState.todaySnackCount = it.size
                    viewStateLiveData.postValue(viewState)
                }
            }
        }
        viewModelScope.launch {
            getYesterdaySnacksUseCase.invoke().collect() {
                viewStateLiveData.value?.let { viewState ->
                    viewState.yesterdaySnackCount = it.size
                    viewStateLiveData.postValue(viewState)
                }
            }
        }
        viewModelScope.launch {
            getSnacksPerPeriodUseCase.invoke(PERIOD.MONTH).collect() {
                viewStateLiveData.value?.let { viewState ->
                    viewState.averageSnackCount = it.size
                    viewState.snackLog = it
                    viewStateLiveData.postValue(viewState)
                }
            }
        }
    }
}

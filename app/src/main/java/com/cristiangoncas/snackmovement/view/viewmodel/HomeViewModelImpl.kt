package com.cristiangoncas.snackmovement.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cristiangoncas.snackmovement.usecases.GetAvgSnacksPerPeriodUseCase
import com.cristiangoncas.snackmovement.usecases.GetTodaySnacksUseCase
import com.cristiangoncas.snackmovement.usecases.GetTopChallengesUseCase
import com.cristiangoncas.snackmovement.usecases.GetYesterdaySnacksUseCase
import com.cristiangoncas.snackmovement.usecases.PERIOD
import com.cristiangoncas.snackmovement.view.state.HomeViewState

class HomeViewModelImpl(
    private val getTodaySnacksUseCase: GetTodaySnacksUseCase,
    private val getYesterdaySnacksUseCase: GetYesterdaySnacksUseCase,
    private val getAvgSnacksPerPeriodUseCase: GetAvgSnacksPerPeriodUseCase,
    private val getTopChallengesUseCase: GetTopChallengesUseCase,
) : HomeViewModel, ViewModel() {

    private val viewStateLiveData: MutableLiveData<HomeViewState> = MutableLiveData(HomeViewState())
    override fun viewState(): LiveData<HomeViewState> {
        loadHome()
        return viewStateLiveData
    }

    override fun loadHome() {
        val today = getTodaySnacksUseCase.invoke()
        viewStateLiveData.value?.let { viewState ->
            viewState.todaySnackCount = today
            viewStateLiveData.postValue(viewState)
        }
        val yesterday = getYesterdaySnacksUseCase.invoke()
        viewStateLiveData.value?.let { viewState ->
            viewState.yesterdaySnackCount = yesterday
            viewStateLiveData.postValue(viewState)
        }
        val avg = getAvgSnacksPerPeriodUseCase.invoke(PERIOD.MONTH)
        viewStateLiveData.value?.let { viewState ->
            viewState.averageSnackCount = avg
            viewStateLiveData.postValue(viewState)
        }
        val top = getTopChallengesUseCase.invoke()
        viewStateLiveData.value?.let { viewState ->
            viewState.topList = top
            viewStateLiveData.postValue(viewState)
        }
    }
}

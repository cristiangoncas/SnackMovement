package com.cristiangoncas.snackmovement.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cristiangoncas.snackmovement.usecases.GetChallengesUseCaseImpl
import com.cristiangoncas.snackmovement.view.state.ChallengesViewState
import kotlinx.coroutines.launch

class ChallengesViewModelImpl : ChallengesViewModel, ViewModel() {

    private val viewStateLiveData: MutableLiveData<ChallengesViewState> = MutableLiveData(
        ChallengesViewState(),
    )

    override fun viewState(): LiveData<ChallengesViewState> {
        loadChallenges()
        return viewStateLiveData
    }

    override fun loadChallenges() {
        viewModelScope.launch {
            val challenges = GetChallengesUseCaseImpl().invoke()
            viewStateLiveData.value?.let { viewState ->
                viewState.challenges = challenges
                viewStateLiveData.postValue(viewState)
            }
        }
    }
}

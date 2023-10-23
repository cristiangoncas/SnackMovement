package com.cristiangoncas.snackmovement.view.viewmodel

import androidx.lifecycle.LiveData
import com.cristiangoncas.snackmovement.view.state.ChallengesViewState

interface ChallengesViewModel {
    fun viewState(): LiveData<ChallengesViewState>

    fun loadChallenges()
}

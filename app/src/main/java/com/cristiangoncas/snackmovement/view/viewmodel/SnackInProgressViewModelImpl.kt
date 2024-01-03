package com.cristiangoncas.snackmovement.view.viewmodel

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cristiangoncas.snackmovement.model.models.Snack
import com.cristiangoncas.snackmovement.usecases.CountDownListener
import com.cristiangoncas.snackmovement.usecases.GetCountDownTimerUseCase
import com.cristiangoncas.snackmovement.usecases.RegisterSnackUseCase
import com.cristiangoncas.snackmovement.view.state.SnackInProgressViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Locale

class SnackInProgressViewModelImpl(
    private val getCountDownTimerUseCase: GetCountDownTimerUseCase,
    private val registerSnackUseCase: RegisterSnackUseCase,
) : SnackInProgressViewModel, ViewModel() {

    private lateinit var currentSnack: Snack
    private var counter: CountDownTimer? = null

    private val viewStateLiveData: MutableLiveData<SnackInProgressViewState> = MutableLiveData(
        SnackInProgressViewState(),
    )

    override fun viewState(): LiveData<SnackInProgressViewState> {
        startCountDown()
        return viewStateLiveData
    }

    override fun setSnack(snack: Snack) {
        currentSnack = snack
    }

    override fun markAsDone() {
        viewModelScope.launch(Dispatchers.IO) {
            registerSnackUseCase.invoke(currentSnack)
            counter?.cancel()
        }
    }

    private fun startCountDown() {
        counter = getCountDownTimerUseCase.invoke(object : CountDownListener {
            override fun onTick(millisUntilFinished: Long) {
                updateCountDownText(millisUntilFinished)
            }

            override fun onFinish() {
            }
        }).start()
    }

    private fun updateCountDownText(millisUntilFinished: Long) {
        val minutes = (millisUntilFinished / 1000) / 60
        val seconds = (millisUntilFinished / 1000) % 60
        val timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds)
        viewStateLiveData.value?.let { viewState ->
            viewState.timeLeft = timeFormatted
            viewStateLiveData.postValue(viewState)
        }
    }
}

package com.cristiangoncas.snackmovement.usecases

import android.os.CountDownTimer
import com.cristiangoncas.snackmovement.view.viewmodel.SnackInProgressViewModelImpl

interface GetCountDownTimerUseCase {

    operator fun invoke(countdownListener: CountDownListener, timeInMillis: Long = 120000): CountDownTimer
}

interface CountDownListener {
    fun onTick(millisUntilFinished: Long)

    fun onFinish()
}

class GetCountDownTimerUseCaseImpl : GetCountDownTimerUseCase {
    // TODO: Pass an interface that will receive onTick and onFinish in order to update the UI
    override fun invoke(countdownListener: CountDownListener, timeInMillis: Long): CountDownTimer {
        return object : CountDownTimer(timeInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                countdownListener.onTick(millisUntilFinished)
            }

            override fun onFinish() {
                countdownListener.onFinish()
            }
        }
    }
}

package com.cristiangoncas.snackmovement.view.state

import com.cristiangoncas.snackmovement.model.Challenge

class HomeViewState {
    var todaySnackCount: Int = 0
    var yesterdaySnackCount: Int = 0
    var averageSnackCount: Int = 0
    var topList: ArrayList<Challenge> = arrayListOf()
}

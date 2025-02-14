package com.cristiangoncas.snackmovement.domain

data class NotificationSchedule(
    val id: Int,
    val startTime: String,
    val endTime: String,
    val frequency: Int,
    val isActive: Boolean,
) {
    fun getScheduleText(): String {
        return "$startTime-$endTime, Every $frequency min"
    }
}

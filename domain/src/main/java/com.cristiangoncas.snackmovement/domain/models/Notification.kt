package com.cristiangoncas.snackmovement.domain.models

data class Notification(
    val id: Int,
    val frequency: NotificationFrequency,
    val type: NotificationType,
    val restrictedTimes: Int
)

enum class NotificationType(val id: Int) {
    DAILY_REMINDER(0),
    GOAL_ACHIEVED(1),
    INACTIVITY_ALERT(2);

    companion object {
        fun fromId(id: Int) = entries.firstOrNull { it.id == id } ?: DAILY_REMINDER
    }
}

enum class NotificationFrequency(val id: Int) {
    ONCE_DAILY(0),
    TWICE_DAILY(1),
    HOURLY(2);

    companion object {
        fun fromId(id: Int) = entries.firstOrNull { it.id == id } ?: ONCE_DAILY
    }
}
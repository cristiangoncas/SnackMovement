package com.cristiangoncas.snackmovement.framework.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/** Represents notification settings in the local database */
@Entity(tableName = "notifications")
data class DbNotification(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "frequency")
    val frequency: Int,
    @ColumnInfo(name = "type")
    val type: Int,
    @ColumnInfo(name = "restricted_times")
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

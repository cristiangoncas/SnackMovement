package com.cristiangoncas.snackmovement.model.repository.local

import java.util.Calendar
import java.util.Date

fun Date.getStartOfDayInMillis(): Long {
    val calendar = Calendar.getInstance().apply {
        time = this@getStartOfDayInMillis
        set(Calendar.HOUR_OF_DAY, 0)
        set(Calendar.MINUTE, 0)
        set(Calendar.SECOND, 0)
        set(Calendar.MILLISECOND, 0)
    }
    return calendar.timeInMillis
}

fun Date.getEndOfDayInMillis(): Long {
    val calendar = Calendar.getInstance().apply {
        time = this@getEndOfDayInMillis
        set(Calendar.HOUR_OF_DAY, 23)
        set(Calendar.MINUTE, 59)
        set(Calendar.SECOND, 59)
        set(Calendar.MILLISECOND, 999)
    }
    return calendar.timeInMillis
}
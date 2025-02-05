package com.cristiangoncas.snackmovement.framework.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.cristiangoncas.snackmovement.framework.local.model.DbNotification

@Dao
interface NotificationDao {

    @Insert
    fun insertNotification(notification: DbNotification)

    @Query("SELECT * FROM Notifications WHERE type = :type")
    fun getNotificationByType(type: Int): DbNotification

}
package com.cristiangoncas.snackmovement.framework.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.cristiangoncas.snackmovement.framework.local.model.DbProfile

@Dao
interface ProfileDao {

    @Insert
    fun insertProfile(profile: DbProfile)

    @Query("SELECT * FROM Profile WHERE id = :id")
    fun getProfileById(id: Int): DbProfile

}

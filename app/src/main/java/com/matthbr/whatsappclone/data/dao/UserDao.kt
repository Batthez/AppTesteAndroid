package com.matthbr.whatsappclone.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.matthbr.whatsappclone.domain.model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM User")
    suspend fun getAllUsers(): List<User>

    @Insert
    suspend fun insertUser(vararg user: User)

}
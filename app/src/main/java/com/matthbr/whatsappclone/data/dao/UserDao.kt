package com.matthbr.whatsappclone.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.matthbr.whatsappclone.domain.model.Users
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM Users")
    suspend fun getAllUsers() : Flow<List<Users>>

    @Insert
    suspend fun insertUser(vararg user: Users)

}
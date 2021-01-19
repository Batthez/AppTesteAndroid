package com.matthbr.whatsappclone.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.matthbr.whatsappclone.domain.model.Message
import kotlinx.coroutines.flow.Flow

@Dao
interface MessageDao {

    @Insert
    suspend fun insertNewMessage(message : Message)

    @Query("SELECT * FROM Message")
    suspend fun getAllMessages() : Flow<List<Message>>

}
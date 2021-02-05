package com.matthbr.whatsappclone.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.matthbr.whatsappclone.domain.model.Messages
import kotlinx.coroutines.flow.Flow

@Dao
interface MessageDao {

    @Insert
    suspend fun insertNewMessage(messages : Messages)

    @Query(
        """
        SELECT Messages.* 
        FROM Messages 
        INNER JOIN Chat 
        ON Messages.chatId = Chat.menssage
        WHERE 
        chat.destination = :receiverId
        """
    )
    suspend fun getMessagesFromChat(receiverId: String) : Flow<List<Messages>>

}
package com.matthbr.whatsappclone.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.matthbr.whatsappclone.domain.model.Message

@Dao
interface MessageDao {

    @Insert
    suspend fun insertNewMessage(vararg messages: Message)

    @Query(
        """
        SELECT Message.* 
        FROM Message 
        INNER JOIN Chat 
        ON Message.chatId = Chat.menssage
        WHERE 
        chat.destination = :receiverId
        """
    )
    suspend fun getMessagesFromChat(receiverId: String): List<Message>

}
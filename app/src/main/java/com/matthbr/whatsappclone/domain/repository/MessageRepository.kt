package com.matthbr.whatsappclone.domain.repository

import com.matthbr.whatsappclone.data.dao.MessageDao
import com.matthbr.whatsappclone.domain.model.Message
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


interface MessageRepository {
    suspend fun getMessagesFromRemetent(remetentId: String): List<Message>
    suspend fun insertMessage(vararg message: Message)
}

class MessageRepositoryImpl(
    val messageDao: MessageDao
) : MessageRepository {

    override suspend fun getMessagesFromRemetent(remetentId: String): List<Message> =
        withContext(Dispatchers.IO) {
            messageDao.getMessagesFromChat(remetentId)
        }

    override suspend fun insertMessage(vararg message: Message) = withContext(Dispatchers.IO) {
        messageDao.insertNewMessage(*message)
    }

}
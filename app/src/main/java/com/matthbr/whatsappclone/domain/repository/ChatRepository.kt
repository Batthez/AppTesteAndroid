package com.matthbr.whatsappclone.domain.repository

import com.matthbr.whatsappclone.data.dao.ChatDao
import com.matthbr.whatsappclone.domain.model.Chat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface ChatRepository {
    suspend fun insertNewChat(chat: Chat)
}

class ChatRepositoryImpl(
    val chatDao: ChatDao
) : ChatRepository {
    override suspend fun insertNewChat(chat: Chat) = withContext(Dispatchers.IO) {
        chatDao.registerNewChatMessage(chat)
    }
}
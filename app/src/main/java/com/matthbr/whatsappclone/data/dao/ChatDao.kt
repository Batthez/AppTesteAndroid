package com.matthbr.whatsappclone.data.dao

import androidx.room.Dao
import androidx.room.Insert
import com.matthbr.whatsappclone.domain.model.Chat

@Dao
interface ChatDao {

    @Insert
    suspend fun registerNewChatMessage(vararg chat: Chat)

}
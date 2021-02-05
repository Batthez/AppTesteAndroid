package com.matthbr.whatsappclone.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.matthbr.whatsappclone.data.dao.ChatDao
import com.matthbr.whatsappclone.data.dao.MessageDao
import com.matthbr.whatsappclone.data.dao.UserDao
import com.matthbr.whatsappclone.domain.model.Chat
import com.matthbr.whatsappclone.domain.model.Message
import com.matthbr.whatsappclone.domain.model.User

@Database(
    version = 1,
    exportSchema = false,
    entities = [
        Message::class,
        Chat::class,
        User::class
    ]
)
abstract class WhatsAppDb : RoomDatabase() {

    abstract fun messageDao(): MessageDao
    abstract fun chatDao(): ChatDao
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: WhatsAppDb? = null

        fun getDatabase(context: Context): WhatsAppDb {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, WhatsAppDb::class.java,
                    "whatsApp_clone_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }


}
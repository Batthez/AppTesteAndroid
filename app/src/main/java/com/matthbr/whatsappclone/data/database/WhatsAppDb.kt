package com.matthbr.whatsappclone.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.matthbr.whatsappclone.data.dao.MessageDao
import com.matthbr.whatsappclone.domain.model.Message

@Database(
    version = 1,
    exportSchema = false,
    entities = [
        Message::class
    ]
)
abstract class WhatsAppDb : RoomDatabase() {

    abstract fun messageDao() : MessageDao

    companion object {
        @Volatile
        private var INSTANCE : WhatsAppDb? = null

        fun getDatabase(context : Context) : WhatsAppDb{

            return INSTANCE ?: synchronized(this){
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
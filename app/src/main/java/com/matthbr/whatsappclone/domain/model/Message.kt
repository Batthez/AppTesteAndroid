package com.matthbr.whatsappclone.domain.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE

@Entity(
  foreignKeys = [
    ForeignKey(
      entity = Chat::class,
      parentColumns = ["chatId"],
      childColumns = ["id"],
      onDelete = CASCADE
    )
  ]
)
data class Message(
  val id : String,
  val message : String,
  val date : String,
  val chatId : String,
  val messageType : Int
)
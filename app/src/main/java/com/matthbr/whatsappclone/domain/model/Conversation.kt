package com.matthbr.whatsappclone.domain.model

import androidx.room.Entity

@Entity
class Message(
  val id : String,
  val message : String,
  val date : String,
  val senderId : String,
  val receiverId : String
)
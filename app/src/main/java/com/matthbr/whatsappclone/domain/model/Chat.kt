package com.matthbr.whatsappclone.domain.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Users::class,
            parentColumns = ["remetent"],
            childColumns = ["id"],
            onDelete = CASCADE
        ),
        ForeignKey(
            entity = Users::class,
            parentColumns = ["destination"],
            childColumns = ["id"],
            onDelete = CASCADE
        ),
        ForeignKey(
            entity = Message::class,
            parentColumns = ["id"],
            childColumns = ["message"],
            onDelete = CASCADE
        )
    ]
)
data class Chat(
    var id: String,
    var remetent : String,
    var destination: String,
    var menssage : String
)
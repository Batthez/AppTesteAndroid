package com.matthbr.whatsappclone.domain.model

import androidx.room.Entity

@Entity
data class Users(
    var id: String,
    var name: String,
    var status : String,
    var telephoneNumber: String
)
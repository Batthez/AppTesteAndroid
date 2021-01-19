package com.matthbr.whatsappclone.view.conversations.model

import android.net.Uri

class Conversations(
        var id : Int,
        var contactName : String,
        var imgResource : Uri,
        var messages : List<NewMessages>,
        var visualized : Boolean
)
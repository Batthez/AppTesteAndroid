package com.matthbr.whatsappclone.view.adapter.callback

import androidx.recyclerview.widget.DiffUtil
import com.matthbr.whatsappclone.view.model.Conversations
import kotlin.math.sign

class ConversationsCallback(
    val oldList : List<Conversations>,
    val newList : List<Conversations>
) : DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }

}
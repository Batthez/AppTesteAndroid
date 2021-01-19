package com.matthbr.whatsappclone.view.conversations

import androidx.recyclerview.widget.DiffUtil
import com.matthbr.whatsappclone.view.conversations.model.Conversations

class ConversationsAdapterCallback(
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
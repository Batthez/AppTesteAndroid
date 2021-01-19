package com.matthbr.whatsappclone.view.conversations

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.matthbr.whatsappclone.R
import com.matthbr.whatsappclone.view.conversations.model.Conversations


class ConversationsAdapter(
    private var conversations: List<Conversations>
) : RecyclerView.Adapter<ConversationsAdapter.ConversationsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConversationsViewHolder = ConversationsViewHolder.from(parent)

    override fun getItemCount(): Int = conversations.size

    override fun onBindViewHolder(holder: ConversationsViewHolder, position: Int) {
        holder.bind(conversations[position])
    }

    fun submitList(newConversations : List<Conversations>){
        val diffResult = DiffUtil.calculateDiff(ConversationsAdapterCallback(newConversations, newConversations))
        diffResult.dispatchUpdatesTo(this)
    }

    class ConversationsViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        private val ivUserImage = itemView.findViewById<ImageView>(R.id.image_view)
        private val tvContactName = itemView.findViewById<TextView>(R.id.text_nome)
        private val tvUltimaMensagem = itemView.findViewById<TextView>(R.id.text_view_ultima_mensagem)
        private val tvHorarioUltimaMensagem = itemView.findViewById<TextView>(R.id.text_horario)
        private val tvQuantidadeNovasMensagens = itemView.findViewById<TextView>(R.id.text_view_quantidade_novas_mensagens)

        fun bind(item : Conversations){
            with(item){
                ivUserImage.setImageURI(imgResource)
                tvContactName.text = contactName
                tvUltimaMensagem.text = messages.last().message
                tvHorarioUltimaMensagem.text = messages.last().hour
                if(!visualized){
                    tvQuantidadeNovasMensagens.visibility = View.GONE
                    tvQuantidadeNovasMensagens.text = messages.count().toString()
                }
            }
        }

        companion object{
            fun from(parent: ViewGroup) : ConversationsViewHolder {
                val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_conversation_layout, parent,false)
                return ConversationsViewHolder(itemView)
            }
        }
    }
}
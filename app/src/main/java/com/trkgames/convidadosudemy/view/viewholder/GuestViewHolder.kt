package com.trkgames.convidadosudemy.view.viewholder

import android.content.DialogInterface
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.trkgames.convidadosudemy.R
import com.trkgames.convidadosudemy.databinding.RowGuestBinding
import com.trkgames.convidadosudemy.model.GuestModel
import com.trkgames.convidadosudemy.view.listener.OnGuestListener

class GuestViewHolder(private val bind: RowGuestBinding, private val listener: OnGuestListener) :
    RecyclerView.ViewHolder(bind.root) {

    fun bind(guest: GuestModel) {
        bind.textName.text = guest.name

        bind.textName.setOnClickListener{
             listener.onClick(guest.id)
        }

        bind.textName.setOnLongClickListener {

            AlertDialog.Builder(itemView.context)
                .setTitle("Remoçao de convidado")
                .setMessage("Tem certaza da remoçao?")
                .setPositiveButton("Sim") { dialog, which -> listener.onDelete(guest.id) }
                .setNegativeButton("Nao", null)
                .create()
                .show()


            true
             }


    }

}
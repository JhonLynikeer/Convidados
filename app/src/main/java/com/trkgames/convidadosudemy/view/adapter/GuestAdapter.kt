package com.trkgames.convidadosudemy.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.trkgames.convidadosudemy.databinding.RowGuestBinding
import com.trkgames.convidadosudemy.model.GuestModel
import com.trkgames.convidadosudemy.view.listener.OnGuestListener
import com.trkgames.convidadosudemy.view.viewholder.GuestViewHolder
import java.lang.reflect.Type

class GuestAdapter : RecyclerView.Adapter<GuestViewHolder>() {

        private var guestList: List<GuestModel> = listOf()
        private lateinit var listener: OnGuestListener


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {

                val item = RowGuestBinding.inflate(LayoutInflater.from(parent.context), parent, false)

                return GuestViewHolder(item, listener)
        }

        override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
                holder.bind(guestList[position])
        }

        override fun getItemCount(): Int {
                return guestList.count()
        }

        fun updatedGuests(list: List<GuestModel>){
                guestList = list
                notifyDataSetChanged()
        }

        fun attachListener(guestListener: OnGuestListener){
                listener = guestListener
        }
}
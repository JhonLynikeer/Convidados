package com.trkgames.convidadosudemy.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.trkgames.convidadosudemy.constants.DataBaseConstants
import com.trkgames.convidadosudemy.databinding.FragmentAllGuestsBinding
import com.trkgames.convidadosudemy.view.adapter.GuestAdapter
import com.trkgames.convidadosudemy.view.listener.OnGuestListener
import com.trkgames.convidadosudemy.viewmodel.AllGuestsViewModel


class AllGuestsFragment : Fragment() {

    private var _binding: FragmentAllGuestsBinding? = null
    private lateinit var viewModel: AllGuestsViewModel
    private val adapter = GuestAdapter()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, b: Bundle? ): View {

        viewModel = ViewModelProvider(this).get(AllGuestsViewModel::class.java)
        _binding = FragmentAllGuestsBinding.inflate(inflater, container, false)

        //Layout
        binding.recyclerAllGuests.layoutManager = LinearLayoutManager(context)


        //Adapter
        binding.recyclerAllGuests.adapter = adapter

        val listener = object : OnGuestListener {
            override fun onClick(id: Int) {
                val intent = Intent(context, GuestFormActivity::class.java)
                val bundle = Bundle()
                bundle.putInt(DataBaseConstants.GUEST.ID, id)
                intent.putExtras(bundle)


                startActivity(intent)
            }

            override fun onDelete(id: Int) {
                viewModel.delete(id)
                viewModel.getAll()
            }



        }

        adapter.attachListener(listener)

        viewModel.getAll()

        observe()

        return binding.root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observe(){
        viewModel.guests.observe(viewLifecycleOwner) {
            adapter.updatedGuests(it)
        }
    }



}
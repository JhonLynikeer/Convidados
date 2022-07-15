package com.trkgames.convidadosudemy.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.trkgames.convidadosudemy.model.GuestModel
import com.trkgames.convidadosudemy.viewmodel.GuestFormViewModel
import com.trkgames.convidadosudemy.R
import com.trkgames.convidadosudemy.constants.DataBaseConstants
import com.trkgames.convidadosudemy.databinding.ActivityGuestFormBinding

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityGuestFormBinding
    private lateinit var viewModel: GuestFormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGuestFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)
        binding.radioPresent.isChecked = true

        binding.buttonSave.setOnClickListener(this)


        loadData()


    }


    override fun onClick(v: View) {
        if(v.id == R.id.button_save){
            val nome = binding.editName.text.toString()
            val presence = binding.radioPresent.isChecked

            val model = GuestModel(0,nome , presence)

            viewModel.insert(model)
        }
    }

    private fun loadData(){
        val bundle = intent.extras
        if (bundle != null){
            val guestId = bundle.getInt(DataBaseConstants.GUEST.ID)
            viewModel.get(guestId)
        }
    }

}
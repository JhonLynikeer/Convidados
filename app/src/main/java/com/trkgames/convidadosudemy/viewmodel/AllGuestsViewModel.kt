package com.trkgames.convidadosudemy.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.trkgames.convidadosudemy.model.GuestModel
import com.trkgames.convidadosudemy.repository.GuestRepository

class AllGuestsViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: GuestRepository = GuestRepository.getInstance(application.applicationContext)

    private val listAllGuests = MutableLiveData<List<GuestModel>>()
    val guests: LiveData<List<GuestModel>> = listAllGuests

    fun getAll(){
        listAllGuests.value = repository.getAll()
    }

    fun delete(id: Int){
        repository.delete(id)
    }


}
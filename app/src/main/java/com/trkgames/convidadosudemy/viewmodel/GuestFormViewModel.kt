package com.trkgames.convidadosudemy.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.trkgames.convidadosudemy.model.GuestModel
import com.trkgames.convidadosudemy.repository.GuestRepository

class GuestFormViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = GuestRepository.getInstance(application)

    private val guestModel = MutableLiveData<GuestModel>()
    val guest: LiveData<GuestModel> = guestModel


    fun insert(guest: GuestModel){
        repository.insert(guest)
    }

    fun get(id: Int) {
        repository.get(id)
    }

}
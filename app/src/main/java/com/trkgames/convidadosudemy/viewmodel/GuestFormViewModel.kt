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

    private val _saveGuest = MutableLiveData<String>()
    val saveGuest: LiveData<String> = _saveGuest


    fun save(guest: GuestModel){
        if (guest.id == 0){
           if (repository.insert(guest)){
               _saveGuest.value = "Inserçao com sucesso"
           } else {
               _saveGuest.value = "Falha"
           }
        } else {
            if (repository.update(guest)){
                _saveGuest.value = "Atualizaçao com sucesso"
            } else {
                _saveGuest.value = "Falha"
            }
        }

    }


    fun get(id: Int) {
       guestModel.value = repository.get(id)
    }

}
package com.example.desafiowebservices.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafiowebservices.models.Res
import com.example.desafiowebservices.service.Service
import kotlinx.coroutines.launch

class MainViewModel(val service: Service): ViewModel() {
    val listaComics = MutableLiveData<Res>()

    fun getListRepoComics(){
        viewModelScope.launch {
            listaComics.value = service.getHQ (
                0,
                10,
                "1",
                "6eb7e8896ec5850c52515a8a23ee97f0",
                "40a3aa568bb269dfad85ae0c4a297181"
            )
        }
    }

}
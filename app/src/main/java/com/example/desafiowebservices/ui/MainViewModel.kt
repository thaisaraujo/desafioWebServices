package com.example.desafiowebservices.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafiowebservices.models.Comics
import com.example.desafiowebservices.service.Service
import kotlinx.coroutines.launch

class MainViewModel(val service: Service): ViewModel() {
    val listaComics = MutableLiveData<ArrayList<Comics>>()

    fun getListRepoComics(){
        viewModelScope.launch {
            listaComics.value = service.getHQ()
        }
    }

}
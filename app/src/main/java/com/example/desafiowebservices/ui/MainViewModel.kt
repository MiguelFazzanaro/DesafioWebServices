package com.example.desafiowebservices.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafiowebservices.models.Msg
import com.example.desafiowebservices.services.Service
import com.example.desafiowebservices.services.service
import kotlinx.coroutines.launch

class MainViewModel(service: Service) : ViewModel() {

    val comics = MutableLiveData<Msg>()

    fun getComics (){
        viewModelScope.launch {
            comics.value = service.getComicsRepo(
                1,
                15,
                "1",
                "d5bbf7fca619cb6f20ca7a1f344dd5ec",
                "e9ef396685a3f9d8644b5a12c8bbab78",
                "1009610",
                "title"
            )
        }
    }
}
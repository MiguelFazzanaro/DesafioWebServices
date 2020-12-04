package com.example.desafiowebservices.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafiowebservices.models.Results
import com.example.desafiowebservices.services.Service
import com.example.desafiowebservices.services.service
import kotlinx.coroutines.launch

class MainViewModel(service: Service) : ViewModel() {
    val comics = MutableLiveData<ArrayList<Results>>()

    fun getComics (){
        viewModelScope.launch {
//            Log.i("Tag",
            service.getComicsRepo(
                1,
                10,
                "1",
                "d5bbf7fca619cb6f20ca7a1f344dd5ec",
                "e9ef396685a3f9d8644b5a12c8bbab78",
                "1009610",
                "title"
//            ).toString()
            )
        }
    }
}
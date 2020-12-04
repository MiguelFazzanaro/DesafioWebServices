package com.example.desafiowebservices.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.desafiowebservices.R
import com.example.desafiowebservices.services.service
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
    , HqAdapter.onHqClick
{

    lateinit var adapterR : HqAdapter

    private val viewModel by viewModels<MainViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(service) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHqs.layoutManager = GridLayoutManager(this, 3)
        rvHqs.setHasFixedSize(true)

        viewModel.comics.observe(this) {
            adapterR = HqAdapter(it,this)
            rvHqs.adapter = adapterR
        }
        viewModel.getComics()
    }

    override fun hqClick(position: Int) {
        var hqClick = viewModel.comics.value?.data?.results?.get(position)
        var intent = Intent(this, DetalhesHqActivity::class.java)
        intent.putExtra("hqClick", hqClick)
        startActivity(intent)
    }
}

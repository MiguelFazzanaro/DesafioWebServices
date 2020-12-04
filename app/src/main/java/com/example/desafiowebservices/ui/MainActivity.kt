package com.example.desafiowebservices.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.desafiowebservices.R
import com.example.desafiowebservices.models.Results
import com.example.desafiowebservices.services.service
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
    , HqAdapter.onHqClick
{
//    var lista: ArrayList<Hq> = getHq()
    lateinit var adapterR: HqAdapter

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

//        rvHqs.adapter = adapterR
        rvHqs.layoutManager = GridLayoutManager(this, 3)
        rvHqs.setHasFixedSize(true)

        viewModel.comics.observe(this) {
            adapterR = HqAdapter(it,this)
            rvHqs.adapter = adapterR
        }
        viewModel.getComics()
    }

//    private fun getHq(): ArrayList<Hq> {
//        var hq1 = Hq(1,"Amazing Spider Man","Amazing Spider Man Amazing Spider Man Amazing Spider Man Amazing Spider Man Amazing Spider Man Amazing Spider Man Amazing Spider Man Amazing Spider Man" , "April 30, 2014", 5.99,30, R.drawable.hq_hoi, R.drawable.hq_hoi)
//        return arrayListOf(hq1,hq1,hq1,hq1,hq1,hq1,hq1,hq1,hq1,hq1,hq1,hq1)
//    }
    override fun hqClick(position: Int) {
        val hqClick = viewModel.comics.value?.get(position)
        var intent = Intent(this, DetalhesHqActivity::class.java)
        intent.putExtra("hqClick", hqClick)
        startActivity(intent)
    }
}

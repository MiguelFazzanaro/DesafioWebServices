package com.example.desafiowebservices.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.desafiowebservices.R
import com.example.desafiowebservices.services.service
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
//    , HqAdapter.onHqClick
{

//    var lista: ArrayList<Hq> = getHq()
    var adapterR: HqAdapter = HqAdapter()

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

        rvHqs.adapter = adapterR
        rvHqs.layoutManager = GridLayoutManager(this, 3)
        rvHqs.setHasFixedSize(true)



        viewModel.comics.observe(this) {
            adapterR.addList(it)
        }
        viewModel.getComics()
//        Log.i("Tag", "${viewModel.comics}")
    }

//    private fun getHq(): ArrayList<Hq> {
//        var hq1 = Hq(1,"Amazing Spider Man","Amazing Spider Man Amazing Spider Man Amazing Spider Man Amazing Spider Man Amazing Spider Man Amazing Spider Man Amazing Spider Man Amazing Spider Man" , "April 30, 2014", 5.99,30, R.drawable.hq_hoi, R.drawable.hq_hoi)
//        return arrayListOf(hq1,hq1,hq1,hq1,hq1,hq1,hq1,hq1,hq1,hq1,hq1,hq1)
//    }
//    override fun hqClick(position: Int) {
//        val hq = viewModel.comics.get(position)
//
//        var id = hq.id
//        var titulo = hq.title
//        var descricao = hq.description
//        var publicacao = hq.modified
//        var preco = hq.prices
//        var paginas = hq.pageCount
//        var imagem = hq.thumbnail
//
//        adapter.notifyItemChanged(position)
//        activityDetalheHq(hq)
//    }
//
//    fun activityDetalheHq(hq: Hq) {
//        var intent = Intent(this, DetalhesHqActivity::class.java)
//        intent.putExtra("hq", hq)
//        startActivity(intent)
//    }
}

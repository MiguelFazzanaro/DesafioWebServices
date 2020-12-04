package com.example.desafiowebservices.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.desafiowebservices.R
import com.example.desafiowebservices.models.Results
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detalhes_hq.*

class DetalhesHqActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_hq)

        setSupportActionBar(tbDetalhes)
        tbDetalhes.setNavigationOnClickListener(View.OnClickListener() {
            onBackPressed()
        })

        val detail = intent.getSerializableExtra("hqClick") as? Results
        var imagemHq = (detail?.images?.get(0)?.path) + "." + (detail?.images?.get(0)?.extension)
        var imagemFundo = (detail?.images?.get(0)?.path) + "/landscape_incredible" + "." + (detail?.images?.get(0)?.extension)

        Picasso.get().load("$imagemHq").into(ivDetalheHqImage)
        Picasso.get().load("$imagemFundo").into(ivDetalheHqFundo)

        tvDetalheHqData.text = detail?.dates?.get(0)?.date
        if(detail?.description == null){
            tvDetalheHqDescricao.text = "No description found for this comic. Please check www.marvel.com/comics for more information!"
        }else {
            tvDetalheHqDescricao.text = detail?.description
        }
        tvDetalheHqNome.text = detail?.title
        tvDetalheHqPagina.text = detail?.pageCount.toString()
        tvDetalheHqPreco.text = detail?.prices?.get(0)?.price.toString()

        ivDetalheHqImage.setOnClickListener {
            var foto = detail
            var intent = Intent(this, FotoHqActivity::class.java)
            intent.putExtra("Foto", foto)
            startActivity(intent)
        }
    }
}
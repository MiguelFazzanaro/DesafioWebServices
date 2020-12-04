package com.example.desafiowebservices.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.desafiowebservices.R
import com.example.desafiowebservices.models.Results
import kotlinx.android.synthetic.main.activity_detalhes_hq.*

class DetalhesHqActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_hq)

        setSupportActionBar(tbDetalhes)
        tbDetalhes.setNavigationOnClickListener(View.OnClickListener() {
            onBackPressed()
        })

        ivDetalheHqImage.setOnClickListener {
            var intent = Intent(this, FotoHqActivity::class.java)
            startActivity(intent)
        }

        val detail = intent.getSerializableExtra("hq") as? Results
       // ivDetalheHqImage.setImageResource(detail!!.thumbnail)
       // ivDetalheHqFundo.setImageResource(detail.images)
        tvDetalheHqData.text = detail!!.date
        tvDetalheHqDescricao.text = detail.description
        tvDetalheHqNome.text = detail.title
        tvDetalheHqPagina.text = detail.pageCount.toString()
        tvDetalheHqPreco.text = detail.prices.toString()
    }
}
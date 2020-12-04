package com.example.desafiowebservices.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.desafiowebservices.R
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_detalhes_hq.*
import kotlinx.android.synthetic.main.activity_foto_hq.*

class FotoHqActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foto_hq)

        setSupportActionBar(tbFoto)
        tbCadastro.setNavigationOnClickListener(View.OnClickListener() {
            onBackPressed()
        })


    }
}

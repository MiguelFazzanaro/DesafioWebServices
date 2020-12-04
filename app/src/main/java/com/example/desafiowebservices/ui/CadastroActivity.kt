package com.example.desafiowebservices.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.desafiowebservices.R
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        setSupportActionBar(tbCadastro)
        tbCadastro.setNavigationOnClickListener(View.OnClickListener() {
            onBackPressed()
        })

        btSave.setOnClickListener {
            startActivity(Intent (this, MainActivity::class.java))
        }
    }
}
package com.example.desafiowebservices.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.desafiowebservices.R
import com.example.desafiowebservices.models.Results
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_foto_hq.*

class FotoHqActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foto_hq)

        setSupportActionBar(tbFoto)
        tbFoto.setNavigationOnClickListener(View.OnClickListener() {
            onBackPressed()
        })

        val foto = intent.getSerializableExtra("Foto") as? Results
        var fullscreen = (foto?.images?.get(0)?.path) + "." + (foto?.images?.get(0)?.extension)

        Picasso.get().load("$fullscreen").into(ivFotoHqImage)
    }
}

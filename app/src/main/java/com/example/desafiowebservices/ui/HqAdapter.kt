package com.example.desafiowebservices.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiowebservices.R
import com.example.desafiowebservices.models.Msg
import com.squareup.picasso.Picasso

class HqAdapter (
    var listaHq: Msg,
    val listener: onHqClick
    ):
    RecyclerView.Adapter<HqAdapter.HqViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HqAdapter.HqViewHolder {
        return HqViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent,false))
    }

    override fun onBindViewHolder(holder: HqAdapter.HqViewHolder, position: Int) {
        val hq = listaHq.data.results[position]
        var imageCompleta = (hq.images.get(0).path)+ "." + (hq.images.get(0).extension)
        holder.numero.text = hq.id.toString()
        Picasso.get().load("$imageCompleta").into(holder.imagem)
    }

    override fun getItemCount() = listaHq.data.results.size

    interface onHqClick {
        fun hqClick (position: Int)
    }

    inner class HqViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val numero: TextView = itemView.findViewById(R.id.tvHqNumber)
        val imagem: ImageView = itemView.findViewById(R.id.ivHqImage)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (RecyclerView.NO_POSITION != position) {
                listener.hqClick(position)
            }
        }
    }
}

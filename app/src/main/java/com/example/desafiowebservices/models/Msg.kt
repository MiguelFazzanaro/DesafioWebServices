package com.example.desafiowebservices.models

import java.io.Serializable

data class Msg (var data: Data)

data class Data (val offset: Int, var results: ArrayList<Results>)

data class Results (
    var id: Int,
    var title: String,
    var description: String,
    var date: String,
    var prices: ArrayList<Prices>,
    var pageCount: Int,
    var images: ArrayList<Images>) : Serializable

data class Images (var path: String, var extension: String)

data class Prices (var type: String, var price: Double)
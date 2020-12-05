package com.example.desafiowebservices.models

import java.io.Serializable

data class Res(val data: Data)

data class Data(val offset: Int = 0,
                var results: ArrayList<Results>)

data class Results(val id: Int,
                   val title: String,
                   val description: String,
                   val issueNumber: String,
                   val variantDescription: String,
                   val pageCount: Int,
                   val dates: List<Dates>,
                   val prices: List<Prices>,
                   val thumbnail: Thumbnail): Serializable

data class Thumbnail(val path: String, val extension: String)

data class Prices(val type: String, val price: Double)

data class Dates(val type: String, val date: String)

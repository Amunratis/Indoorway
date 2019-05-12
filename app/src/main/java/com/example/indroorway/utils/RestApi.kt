package com.example.indroorway.utils

import com.example.indroorway.models.CountriesPojo

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface RestApi {



    @GET("all")
    fun getCountries(): Call<List<CountriesPojo>>

}


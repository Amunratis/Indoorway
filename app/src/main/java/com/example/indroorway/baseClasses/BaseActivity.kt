package com.example.indroorway.baseClasses

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

import com.example.indroorway.App


import javax.inject.Inject

import retrofit2.Retrofit

open class BaseActivity : AppCompatActivity() {

    @Inject
    var retrofit: Retrofit? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        (application as App).netComponent.inject(this)
    }
}

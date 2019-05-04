package com.example.indroorway.baseClasses

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

import com.example.indroorway.App




import retrofit2.Retrofit
import javax.inject.Inject

open class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        (application as App).getNetComponent()?.inject(this)
    }
}

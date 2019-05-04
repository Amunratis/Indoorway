package com.example.indroorway

import android.app.Application
import android.location.LocationManager
import com.example.indroorway.dagger.NetComponent

import com.example.indroorway.dagger.AppModule
import com.example.indroorway.dagger.DaggerNetComponent
import com.example.indroorway.dagger.NetModule
import javax.inject.Inject


class App : Application() {


    companion object {
        //platformStatic allow access it from java code
        @JvmStatic lateinit  var mNetComponent: NetComponent
    }

    @Inject
    lateinit var locationManager: LocationManager

    override fun onCreate() {
        super.onCreate()

        mNetComponent = DaggerNetComponent.builder()
                .appModule(AppModule(this))
                .netModule(NetModule(" https://restcountries.eu/rest/v2/"))

                .build()
    }


    fun getNetComponent(): NetComponent? {
        return mNetComponent
    }


}
package com.example.indroorway;

import android.app.Application;

import com.example.indroorway.utils.AppModule;
import com.example.indroorway.utils.NetModule;
import com.example.indroorway.utils.NetComponent;



public class App extends Application {
    private NetComponent mNetComponent;

    private static App mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance=this;


        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://restcountries.eu/rest/v2/"))
                .build();
    }

    public static synchronized App getmInstance () {return mInstance;}

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}
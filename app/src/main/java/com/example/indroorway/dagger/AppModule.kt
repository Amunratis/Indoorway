package com.example.indroorway.dagger


import android.app.Application

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

@Module
class AppModule(internal var mApplication: Application) {

    @Provides
    @Singleton
    internal fun provideApplication(): Application {
        return mApplication
    }
}

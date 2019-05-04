package com.example.indroorway.dagger


import com.example.indroorway.baseClasses.BaseActivity

import javax.inject.Singleton

import dagger.Component

@Singleton
@Component(modules = [AppModule::class, NetModule::class])
interface NetComponent {
    fun inject(baseActivity: BaseActivity)
}
package com.example.indroorway.utils;


import com.example.indroorway.baseClasses.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(BaseActivity baseActivity);
}
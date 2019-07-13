package com.ajinkyad.weatherApp.di.module;


import com.ajinkyad.weatherApp.ui.WeatherDetailsActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainActivityModule {
    @ContributesAndroidInjector()
    abstract WeatherDetailsActivity contributeScrollingActivity();
}
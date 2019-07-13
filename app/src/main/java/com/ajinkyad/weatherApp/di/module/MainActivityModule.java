package com.ajinkyad.weatherApp.di.module;


import com.ajinkyad.weatherApp.ui.ScrollingActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainActivityModule {
    @ContributesAndroidInjector()
    abstract ScrollingActivity contributeScrollingActivity();
}
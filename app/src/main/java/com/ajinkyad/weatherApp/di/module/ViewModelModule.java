package com.ajinkyad.weatherApp.di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.ajinkyad.weatherApp.di.qualifiers.ViewModelKey;
import com.ajinkyad.weatherApp.viewmodel.ProjectViewModelFactory;
import com.ajinkyad.weatherApp.viewmodel.WeatherViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(WeatherViewModel.class)
    abstract ViewModel bindWeatherViewModel(WeatherViewModel model);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ProjectViewModelFactory projectViewModelFactory);
}
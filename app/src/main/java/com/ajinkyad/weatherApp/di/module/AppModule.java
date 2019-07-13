package com.ajinkyad.weatherApp.di.module;

import android.app.Application;
import android.content.Context;

import com.ajinkyad.weatherApp.repository.WeatherAPI;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module(includes = {ViewModelModule.class,
        NetworkModule.class
})
public class AppModule {

    @Provides
    @Singleton
    WeatherAPI provideCircleService(Retrofit retrofit) {
        return retrofit.create(WeatherAPI.class);
    }

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

}
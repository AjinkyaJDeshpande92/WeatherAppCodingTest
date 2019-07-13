package com.ajinkyad.weatherApp.di.component;

import android.app.Application;

import com.ajinkyad.weatherApp.WeatherApplication;
import com.ajinkyad.weatherApp.di.module.AppModule;
import com.ajinkyad.weatherApp.di.module.MainActivityModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class,
        MainActivityModule.class})
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(WeatherApplication application);
}
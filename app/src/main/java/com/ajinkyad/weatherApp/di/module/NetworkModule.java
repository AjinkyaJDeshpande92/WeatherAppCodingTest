package com.ajinkyad.weatherApp.di.module;

import androidx.annotation.NonNull;

import com.ajinkyad.weatherApp.BuildConfig;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    private static String HOST = BuildConfig.BASE_URL_PROTOCOL.toLowerCase() + "://" + BuildConfig.BASE_URL + "/";

    @Provides
    @Singleton
    OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder()
                .build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofitClient(@NonNull OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(getDomainName())
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create()) // Serialize Objects
                .build();
    }


    private static String getDomainName() {
        return HOST;
    }
}
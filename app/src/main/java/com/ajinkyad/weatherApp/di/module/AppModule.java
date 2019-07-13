package com.ajinkyad.weatherApp.di.module;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.ajinkyad.weatherApp.database.AppDatabase;
import com.ajinkyad.weatherApp.database.dao.CityDao;
import com.ajinkyad.weatherApp.database.dao.WeatherDao;
import com.ajinkyad.weatherApp.repository.WeatherAPI;

import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module(includes = {ViewModelModule.class,
        NetworkModule.class
})
public class AppModule {

    private static AppDatabase INSTANCE;

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

    @Singleton
    @Provides
    AppDatabase provideDb(Application app) {

        if (INSTANCE == null) {
            INSTANCE = Room
                    .databaseBuilder(app, AppDatabase.class, AppDatabase.DATABASE_NAME)
                    .addCallback(new RoomDatabase.Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            Executors.newSingleThreadScheduledExecutor().execute(() -> INSTANCE.cityDao().insertAllCities(CityDao.populateDefaultCities()));
                        }
                    })
                    .build();
        }
        return INSTANCE;
    }

    @Singleton
    @Provides
    CityDao getCityDao(AppDatabase db) {
        return db.cityDao();
    }


    @Singleton
    @Provides
    WeatherDao getWeatherDao(AppDatabase db) {
        return db.weatherDao();
    }

}
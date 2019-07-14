package com.ajinkyad.weatherApp.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.ajinkyad.weatherApp.R;
import com.ajinkyad.weatherApp.databinding.ActivityScrollingBinding;
import com.ajinkyad.weatherApp.repository.model.CitiesResponse;
import com.ajinkyad.weatherApp.repository.model.WeatherResponse;
import com.ajinkyad.weatherApp.viewmodel.WeatherViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

import static com.ajinkyad.weatherApp.utils.WeatherUtils.getDisplayTimeFromMillis;
import static com.ajinkyad.weatherApp.utils.WeatherUtils.getSpinnerCityDataset;
import static com.ajinkyad.weatherApp.utils.WeatherUtils.getWeatherDetails;

public class WeatherDetailsActivity extends AppCompatActivity {

    @Inject
    public ViewModelProvider.Factory viewModelFactory;
    private WeatherViewModel weatherViewModel;
    private ActivityScrollingBinding dataBinding;
    private ArrayAdapter<String> spinnerArrayAdapter;
    private ArrayList<CitiesResponse> citiesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_scrolling);
        setSupportActionBar(dataBinding.toolbar);
        initViewModel();
        initCitySpinnerControl();
        initSwipeRefreshListener();
        fetchCitiesList();
    }

    private void initSwipeRefreshListener() {

        dataBinding.weatherSwipeRefreshLayout.setOnRefreshListener(() -> {
            dataBinding.weatherSwipeRefreshLayout.setRefreshing(true);
            fetchWeatherDetails(citiesList.get((int) dataBinding.citiesListSpinner.getSelectedItemId()).getName());
        });
    }

    private void initCitySpinnerControl() {
        spinnerArrayAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_spinner_item,
                        getSpinnerCityDataset(new ArrayList<>()));
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        dataBinding.citiesListSpinner.setAdapter(spinnerArrayAdapter);

        dataBinding.citiesListSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fetchWeatherDetails(citiesList.get(position).getName());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    private void fetchCitiesList() {
        weatherViewModel.getCitiesList().observe(this, citiesResponseList -> {
            if (citiesResponseList != null && !citiesResponseList.isEmpty()) {
                //WE have some data in the Cities List
                //Get the 0th Index and render as default data to the User.
                citiesList = (ArrayList<CitiesResponse>) citiesResponseList;
                setSpinnerData(citiesResponseList);
                fetchWeatherDetails(citiesResponseList.get(0).getName());
            }
        });
    }

    private void setSpinnerData(List<CitiesResponse> citiesResponseList) {

        spinnerArrayAdapter.clear();
        spinnerArrayAdapter.addAll(getSpinnerCityDataset(citiesResponseList));
        spinnerArrayAdapter.notifyDataSetChanged();
    }

    private void setWeatherDetails(WeatherResponse weatherResponse) {
        dataBinding.setCity(weatherResponse.getName());
        dataBinding.setTemperature(weatherResponse.getMain().getTemp() + " \u2109");
        dataBinding.setUpdatedTime(getDisplayTimeFromMillis(weatherResponse.getTime()));
        dataBinding.setWind(weatherResponse.getWindDetails().getSpeed() + " km/h");
        dataBinding.setWeather(getWeatherDetails(weatherResponse));
        dataBinding.weatherSwipeRefreshLayout.setRefreshing(false);
    }


    private void fetchWeatherDetails(String cityName) {
        weatherViewModel.getWeatherDetails(cityName).observe(this, weatherResponse -> {
            if (weatherResponse != null) {
                //We have some valid data from DB
                setWeatherDetails(weatherResponse);
            }
        });
    }

    private void initViewModel() {
        AndroidInjection.inject(this);
        weatherViewModel = ViewModelProviders.of(this, viewModelFactory).get(WeatherViewModel.class);
    }
}

package com.ajinkyad.weatherApp;

import com.ajinkyad.weatherApp.repository.model.WeatherResponse;
import com.ajinkyad.weatherApp.utils.WeatherUtils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class WeatherDetailsUnitTestCases {


    private WeatherUtils weatherUtils;

    @Before
    public void setUp() throws Exception {
        weatherUtils = mock(WeatherUtils.class);
    }

    @After
    public void tearDown() throws Exception {
        weatherUtils = null;
    }


    @Test
    public void checkWeatherDetails_NoDataAvailable() {
        Assert.assertNull(WeatherUtils.getWeatherDetails(null));
    }

    @Test
    public void checkWeatherDetails_NoWeatherDataAvailable() {

        WeatherResponse weatherResponse = mock(WeatherResponse.class);

        Assert.assertNull(WeatherUtils.getWeatherDetails(weatherResponse));
    }

    @Test
    public void checkWeatherDetails_WeatherDataListNotAvailable() {

        WeatherResponse weatherResponse = mock(WeatherResponse.class);
        weatherResponse.setWeather(new ArrayList<>());

        Assert.assertNull(WeatherUtils.getWeatherDetails(weatherResponse));
    }

    @Test
    public void checkWeatherDetails_WeatherMainDataAvailable() {

        WeatherResponse weatherResponse = new WeatherResponse();
        WeatherResponse.WeatherDetails weatherDetails = new WeatherResponse.WeatherDetails();
        weatherDetails.setMain("Windy");
        ArrayList<WeatherResponse.WeatherDetails> weatherDetailsArrayList = new ArrayList<>();
        weatherDetailsArrayList.add(weatherDetails);
        weatherResponse.setWeather(weatherDetailsArrayList);

        Assert.assertEquals("Windy - null", WeatherUtils.getWeatherDetails(weatherResponse));
    }

    @Test
    public void checkWeatherDetails_WeatherDataAvailable() {

        WeatherResponse weatherResponse = new WeatherResponse();
        WeatherResponse.WeatherDetails weatherDetails = new WeatherResponse.WeatherDetails();
        weatherDetails.setMain("Windy");
        weatherDetails.setDescription("Windy Atmosphere");
        ArrayList<WeatherResponse.WeatherDetails> weatherDetailsArrayList = new ArrayList<>();
        weatherDetailsArrayList.add(weatherDetails);
        weatherResponse.setWeather(weatherDetailsArrayList);

        Assert.assertEquals("Windy - Windy Atmosphere", WeatherUtils.getWeatherDetails(weatherResponse));
    }

    @Test
    public void checkSpinnerData_DataNotAvailable() {

        Assert.assertEquals(0, WeatherUtils.getSpinnerCityDataset(new ArrayList<>()).size());
    }

}
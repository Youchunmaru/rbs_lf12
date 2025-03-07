package de.rbsulm.rbs_lf12.controllers;

import de.rbsulm.rbs_lf12.model.WeatherData;
import io.swagger.client.*;
import io.swagger.client.api.ApIsApi;
import io.swagger.client.auth.*;
import io.swagger.client.model.Current;
import io.swagger.client.model.ForecastDay;
import io.swagger.client.model.ForecastForecastday;
import io.swagger.client.model.InlineResponse2001;
import org.threeten.bp.LocalDate;

import java.math.BigDecimal;

public class ApiController {

        public static void main(String[] args) {
            ApiClient defaultClient = Configuration.getDefaultApiClient();

            // Configure API key authorization: ApiKeyAuth
            ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
            ApiKeyAuth.setApiKey("b69476b185a04fd0a6b110333251702");
            // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
            //ApiKeyAuth.setApiKeyPrefix("Token");

            ApIsApi apiInstance = new ApIsApi();
            String q = "Berlin"; // String | Pass US Zipcode, UK Postcode, Canada Postalcode, IP address, Latitude/Longitude (decimal degree) or city name. Visit [request parameter section](https://www.weatherapi.com/docs/#intro-request) to learn more.
            LocalDate dt = LocalDate.now(); // LocalDate | Date on or after 1st Jan, 2015 in yyyy-MM-dd format
            try {
                //Object result = apiInstance.forecastWeather(q, 1, dt, null, null, "en");
                Object result = apiInstance.forecastWeather("Berlin", Integer.valueOf(2), LocalDate.now(),null, null, null);
                //Object result = apiInstance.astronomy(q, dt);
                System.out.println(result);
            } catch (ApiException e) {
                System.err.println("Exception when calling ApisApi#astronomy");
                e.printStackTrace();
            }
        }

        public static WeatherData getWeather(){
            try{
                final InlineResponse2001 response = ApiController.getForecast("48.4008,9.9872", 3);
                final Current current = response.getCurrent();
                final WeatherData.Data currentData = new WeatherData.Data(current.getTempC(), current.getPrecipMm(), current.getWindKph());
                if (response.getForecast().getForecastday().size() > 2)
                {
                    final ForecastDay tomorrow = response.getForecast().getForecastday().get(1).getDay();
                    final WeatherData.Data tomorrowData = new WeatherData.Data(tomorrow.getAvgtempC(), tomorrow.getTotalprecipMm(), tomorrow.getMaxwindKph());
                    final ForecastDay dayAfterTomorrow = response.getForecast().getForecastday().get(2).getDay();
                    final WeatherData.Data dayAfterTomorrowData = new WeatherData.Data(dayAfterTomorrow.getAvgtempC(), dayAfterTomorrow.getTotalprecipMm(), dayAfterTomorrow.getMaxwindKph());
                    return new WeatherData(response.getLocation().getName(),currentData, tomorrowData, dayAfterTomorrowData);
                }
                return new WeatherData(response.getLocation().getName(),currentData, null, null);
            }catch (Exception e){
                return new WeatherData();
            }
        }

        public static InlineResponse2001 getForecast(final String cityName, final int forecastDays){
            ApiClient apiClient = Configuration.getDefaultApiClient();
            ApiKeyAuth ApiKeyAuth = (ApiKeyAuth) apiClient.getAuthentication("ApiKeyAuth");
            ApiKeyAuth.setApiKey("b69476b185a04fd0a6b110333251702");

            ApIsApi apiInstance = new ApIsApi();
            try{
                InlineResponse2001 response = apiInstance.forecastWeather(cityName, forecastDays, LocalDate.now(), null, null ,null);
                return response;
            }catch (ApiException e){
                System.err.println("Exception when calling ApIsApi#astronomy");
                System.err.println(e.getMessage());
                System.err.println(e.getResponseBody());
                System.err.println(e.getCode());
                System.err.println(e.getLocalizedMessage());
                System.err.println(e.getCause());
                System.err.println(e.getStackTrace());
            }
            return null;
        }
}

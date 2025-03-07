/*
 * Weather API
 * # Introduction WeatherAPI.com provides access to weather and geo data via a JSON/XML restful API. It allows developers to create desktop, web and mobile applications using this data very easy. We provide following data through our API:     - Real-time weather - 14 day weather forecast - Historical Weather - Marine Weather and Tide Data - Future Weather (Upto 365 days ahead) - Daily and hourly intervals - 15 min interval (Enterprise only) - Astronomy - Time zone - Location data - Sports - Search or Autocomplete API - Weather Alerts - Air Quality Data - Bulk Request  # Getting Started    You need to [signup](https://www.weatherapi.com/signup.aspx) and then you can find your API key under [your account](https://www.weatherapi.com/login.aspx), and start using API right away!  Try our weather API by using interactive [API Explorer](https://www.weatherapi.com/api-explorer.aspx).  We also have SDK for popular framework/languages available on [Github](https://github.com/weatherapicom/) for quick integrations.  If you find any features missing or have any suggestions, please [contact us](https://www.weatherapi.com/contact.aspx).    # Authentication    API access to the data is protected by an API key. If at anytime, you find the API key has become vulnerable, please regenerate the key using Regenerate button next to the API key.    Authentication to the WeatherAPI.com API is provided by passing your API key as request parameter through an API .      ##  key parameter  key=YOUR API KEY  
 *
 * OpenAPI spec version: 1.0.2
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.ForecastForecastday;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Forecast
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-11-08T07:58:56.667Z")
public class Forecast {
  @SerializedName("forecastday")
  private List<ForecastForecastday> forecastday = null;

  public Forecast forecastday(List<ForecastForecastday> forecastday) {
    this.forecastday = forecastday;
    return this;
  }

  public Forecast addForecastdayItem(ForecastForecastday forecastdayItem) {
    if (this.forecastday == null) {
      this.forecastday = new ArrayList<ForecastForecastday>();
    }
    this.forecastday.add(forecastdayItem);
    return this;
  }

   /**
   * Get forecastday
   * @return forecastday
  **/
  @ApiModelProperty(value = "")
  public List<ForecastForecastday> getForecastday() {
    return forecastday;
  }

  public void setForecastday(List<ForecastForecastday> forecastday) {
    this.forecastday = forecastday;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Forecast forecast = (Forecast) o;
    return Objects.equals(this.forecastday, forecast.forecastday);
  }

  @Override
  public int hashCode() {
    return Objects.hash(forecastday);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Forecast {\n");
    
    sb.append("    forecastday: ").append(toIndentedString(forecastday)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}


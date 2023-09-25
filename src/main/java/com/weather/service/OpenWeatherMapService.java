package com.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.weather.entity.OpenWeatherMapResponse;
import com.weather.entity.WeatherData;
import com.weather.exception.OpenWeatherMapApiException;
import com.weather.repository.WeatherRepository;
import com.weather.utils.WeatherUtils;

@Service
public class OpenWeatherMapService {

	private final String apiKey;
	private final String apiUrl;
	private final RestTemplate restTemplate;

	@Autowired
	private WeatherRepository weatherRepository;

	public OpenWeatherMapService(String apiKey, String apiUrl, RestTemplate restTemplate) {
		this.apiKey = apiKey;
		this.apiUrl = apiUrl;
		this.restTemplate = restTemplate;
	}

	public WeatherData getWeatherData(String location) {
		String url = apiUrl + "?q=" + location + "&appid=" + apiKey;

		try {
			ResponseEntity<OpenWeatherMapResponse> responseEntity = restTemplate.getForEntity(url,
					OpenWeatherMapResponse.class);

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				OpenWeatherMapResponse response = responseEntity.getBody();
				return mapResponseToWeatherData(response);

			} else {
				throw new OpenWeatherMapApiException("Failed to fetch weather data: " + responseEntity.getStatusCode());
			}
		} catch (Exception e) {
			throw new OpenWeatherMapApiException("Error while calling OpenWeatherMap API: " + e.getMessage(), e);
		}
	}

	public WeatherData mapResponseToWeatherData(OpenWeatherMapResponse response) {

		WeatherData weatherData = new WeatherData();

		weatherData.setCityName(response.getName());
		weatherData.setTemperature(WeatherUtils.round(response.getMain().getTemp() - 273.15, 2));
		weatherData.setFeelsLike(WeatherUtils.round(response.getMain().getFeels_like() - 273.15, 2));
		weatherData.setConditions(response.getWeather()[0].getDescription());
		weatherData.setPressure(response.getMain().getPressure());
		weatherData.setHumidity(response.getMain().getHumidity());
		weatherData.setVisibility(response.getVisibility());
		weatherData.setWindSpeed(response.getWind().getSpeed());
		weatherData.setWindDegree(response.getWind().getDeg());
		weatherData.setCloudiness(response.getClouds().getAll());
		weatherData.setGeneratedDate(WeatherUtils.getCurrenttime());

		return weatherData;
	}

	public void savefetchedData(WeatherData weatherData) {
		weatherRepository.save(weatherData);

	}

}

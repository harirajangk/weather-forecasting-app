package com.weather.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.weather.service.OpenWeatherMapService;

@Configuration
public class OpenWeatherMapConfig {
	@Value("${openweathermap.api.key}")
	private String apiKey;

	@Value("${openweathermap.api.base-url}")
	private String apiUrl;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public OpenWeatherMapService openWeatherMapService(RestTemplate restTemplate) {
		return new OpenWeatherMapService(apiKey, apiUrl, restTemplate);
	}
}

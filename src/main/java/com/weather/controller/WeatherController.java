package com.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.weather.entity.WeatherData;
import com.weather.service.OpenWeatherMapService;

@Controller
public class WeatherController {
	private final OpenWeatherMapService openWeatherMapService;

	@Autowired
	public WeatherController(OpenWeatherMapService openWeatherMapService) {
		this.openWeatherMapService = openWeatherMapService;
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/forecast")
	public String getWeatherForecast(@RequestParam String location, Model model) {

		try {
			WeatherData weatherData = openWeatherMapService.getWeatherData(location);
			openWeatherMapService.savefetchedData(weatherData);
			model.addAttribute("weatherData", weatherData);
			return "forecast";
		} catch (Exception e) {
			return "common_error";
		}

	}
}

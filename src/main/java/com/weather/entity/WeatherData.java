package com.weather.entity;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class WeatherData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String cityName;
	private Double temperature;
	private Double feelsLike;
	private Integer pressure;
	private Integer humidity;
	private Integer visibility;
	private Double windSpeed;
	private Integer windDegree;
	private Integer cloudiness;
	private String conditions;
	private Timestamp generatedDate;

	public WeatherData() {
	}

	public WeatherData(String cityName, Double temperature, Double feelsLike, Integer pressure, Integer humidity,
			Integer visibility, Double windSpeed, Integer windDegree, Integer cloudiness, String conditions,
			Timestamp generatedDate) {
		this.cityName = cityName;
		this.temperature = temperature;
		this.feelsLike = feelsLike;
		this.pressure = pressure;
		this.humidity = humidity;
		this.visibility = visibility;
		this.windSpeed = windSpeed;
		this.windDegree = windDegree;
		this.cloudiness = cloudiness;
		this.conditions = conditions;
		this.generatedDate = generatedDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Double getFeelsLike() {
		return feelsLike;
	}

	public void setFeelsLike(Double feelsLike) {
		this.feelsLike = feelsLike;
	}

	public Integer getPressure() {
		return pressure;
	}

	public void setPressure(Integer pressure) {
		this.pressure = pressure;
	}

	public Integer getHumidity() {
		return humidity;
	}

	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}

	public Integer getVisibility() {
		return visibility;
	}

	public void setVisibility(Integer visibility) {
		this.visibility = visibility;
	}

	public Double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(Double windSpeed) {
		this.windSpeed = windSpeed;
	}

	public Integer getWindDegree() {
		return windDegree;
	}

	public void setWindDegree(Integer windDegree) {
		this.windDegree = windDegree;
	}

	public Integer getCloudiness() {
		return cloudiness;
	}

	public void setCloudiness(Integer cloudiness) {
		this.cloudiness = cloudiness;
	}

	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	public Timestamp getGeneratedDate() {
		return generatedDate;
	}

	public void setGeneratedDate(Timestamp generatedDate) {
		this.generatedDate = generatedDate;
	}

}

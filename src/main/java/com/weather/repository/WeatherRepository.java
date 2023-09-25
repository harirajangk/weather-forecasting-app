package com.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weather.entity.WeatherData;


public interface WeatherRepository extends JpaRepository<WeatherData, Long>{

}

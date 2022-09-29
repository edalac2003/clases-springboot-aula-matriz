package com.curso.spring.weather.forecast.service.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather-forecast")
public class WeatherForecastController {

	@GetMapping("/getTemperatureByDate/{date}")
	public float getTemperatureByDate(@PathVariable Date date){
		return 0;
	}
}

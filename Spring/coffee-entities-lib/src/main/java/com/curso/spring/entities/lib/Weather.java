package com.curso.spring.entities.lib;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "WEATHER")
@Data
public class Weather {
	
	@Column(name = "FORECAST_DATE")
	private Date forecastDate;
	@Column(name = "TEMPERATURE")
	private Float temperature;

}

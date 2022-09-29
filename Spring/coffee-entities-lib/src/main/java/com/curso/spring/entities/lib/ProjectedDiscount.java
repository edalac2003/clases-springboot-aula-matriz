package com.curso.spring.entities.lib;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "WEATHER")
@Data
public class ProjectedDiscount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;
	@Column(name = "REGISTER_DATE")
	private Date registerDate;
	@Column(name = "APPLICATION_DATE")
	private Date applicationDate;
	@Column(name = "FORECAST_TEMPERATURE")
	private Float foreCastTemperature;
	@Column(name = "DISCOUNT_PERCENTAGE")
	private Float discountPercentage;
}

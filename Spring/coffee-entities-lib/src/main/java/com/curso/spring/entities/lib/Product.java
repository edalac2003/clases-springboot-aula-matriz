package com.curso.spring.entities.lib;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.curso.spring.entities.lib.constants.MeasureUnit;

import lombok.Data;

@Entity
@Table(name = "PRODUCT")
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "MEASURE_UNIT")
	private MeasureUnit measureUnit;
	
	@OneToMany
	private List<ProductoRaw> productsRaw;
}

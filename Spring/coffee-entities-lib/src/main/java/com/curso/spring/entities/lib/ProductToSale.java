package com.curso.spring.entities.lib;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "PRODUCT_TO_SALE")
@Data
public class ProductToSale {

	@OneToOne
	private Product product;
	
	@ManyToOne
	private Sale sale;
	
	@Column(name = "QUANTITY")
	private Float quantity;
}

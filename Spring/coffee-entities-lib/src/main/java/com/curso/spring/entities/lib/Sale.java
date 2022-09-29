package com.curso.spring.entities.lib;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "SALE")
@Data
public class Sale {

	@Id
	private Integer id;
	
	@ManyToMany
	private Store store;
	@Column(name = "DATE_AND_TIME")
	private Date dateAndTime;
	@Column(name = "TOTAL_PRICE")
	private Float totalPrice;
	@OneToMany
	private List<ProductToSale> productsToSale;
	@Column(name = "DISCOUNT")
	private float discount;
	
	@OneToOne
	private Customer customer;
}

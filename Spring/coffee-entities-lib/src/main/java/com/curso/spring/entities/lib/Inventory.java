package com.curso.spring.entities.lib;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "INVENTORY")
@Data
public class Inventory {

	@OneToOne
	private Store store;
	@OneToOne
	private ProductoRaw productRaw;
	
	@Column(name = "STOCK")
	private float stock;
}

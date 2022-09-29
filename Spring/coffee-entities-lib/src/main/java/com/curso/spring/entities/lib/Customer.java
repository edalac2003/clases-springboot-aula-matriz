package com.curso.spring.entities.lib;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.curso.spring.entities.lib.constants.DocType;

import lombok.Data;

@Entity
@Table(name = "CUSTOMER")
@Data
public class Customer {

	@Id
	@Column(name = "DOC_NUMBER")
	private Short docNumer;
	@Column(name = "DOC_TYPE")
	private DocType docType;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
	
	
}

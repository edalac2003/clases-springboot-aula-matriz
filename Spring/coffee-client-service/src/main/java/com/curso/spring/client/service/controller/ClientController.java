package com.curso.spring.client.service.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.spring.entities.lib.Customer;
import com.curso.spring.entities.lib.constants.DocType;

@RestController
@RequestMapping("/client")
public class ClientController {

	@PostMapping("/create")
	public Customer create(@RequestBody Customer customer) {
		System.out.println("Se creó el nuevo cliente. " + customer);
		return customer;
	}
	
	@PutMapping("/update")
	public void update(@RequestBody Customer customer) {

	}
	
	@GetMapping("/findAll")
	public List<Customer> findAll() {
		return null;
	}
	
	@GetMapping("/findById/{docNumber}")
	@RolesAllowed(value = "")
	public Customer findById(@PathVariable short docNumber) {
		Customer customer = new Customer();
		customer.setDocNumer((short)12345);
		customer.setDocType(DocType.CC);
		customer.setFirstName("Pepito");
		
		return (customer.getDocNumer() == docNumber ? customer : null);
	}
	
	@DeleteMapping("/deleteCustomer/{docNumber}")
	public void  deleteCustomer(@PathVariable String docNumber) {

	}
}

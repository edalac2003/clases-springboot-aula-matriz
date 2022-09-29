package com.curso.spring.sales.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.curso.spring.entities.lib.Customer;

@FeignClient(name = "customerClient", url = "${client.service.base.url}")
public interface CustomerClient {

	@GetMapping("/client/findById/{docNumber}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable short docNumber);
	
	@PostMapping("/client/create")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer);
}

package com.curso.spring.stock.service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.spring.entities.lib.Store;

@RestController
@RequestMapping("/stock/store")
public class StoreController {

	@PostMapping("/save")
	public Store saveStore(@RequestBody Store store) {
		return null;
	}
	
	@PutMapping("/update/{quantity}")
	public void updateStore(@RequestBody Store store) {
		
	}
	
	@GetMapping("/findById/{storeId}")
	public Store findById(@PathVariable short storeId) {
		return null;
	}
	
	@GetMapping("/findAll/{storeId}")
	public List<Store> findAll(@PathVariable short storeId){
		return null;
	}
	
	@DeleteMapping("/delete/{storeId}")
	public void deleteStore(@PathVariable short storeId) {
		
	}
}

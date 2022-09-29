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

import com.curso.spring.entities.lib.ProductoRaw;
import com.curso.spring.entities.lib.Store;

@RestController
@RequestMapping("/stock/raw-product")
public class RawProductController {

	@PostMapping("/save")
	public ProductoRaw saveRawProduct(@RequestBody ProductoRaw productRaw, @RequestBody Store store) {
		return null;
	}
	
	@PutMapping("/update/{quantity}")
	public void updateRawProduct(@RequestBody ProductoRaw productRaw, @RequestBody Store store, float quantity) {
		
	}
	
	@GetMapping("/findById/{productId}/{storeId}")
	public ProductoRaw findRawProductById(@PathVariable short productId, @PathVariable short storeId) {
		return null;
	}
	
	@GetMapping("/findAllByStore/{storeId}")
	public List<ProductoRaw> findAllRawProductoByStore(@PathVariable short storeId){
		return null;
	}
	
	@DeleteMapping("/delete/{productId}/{storeId}")
	public void deleteRawProduct(@PathVariable short productId, @PathVariable short storeId) {
		
	}
}

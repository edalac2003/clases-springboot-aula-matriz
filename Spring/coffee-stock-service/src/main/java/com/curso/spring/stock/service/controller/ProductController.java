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

import com.curso.spring.entities.lib.Product;
import com.curso.spring.entities.lib.Store;

@RestController
@RequestMapping("/stock/product")
public class ProductController {

	@PostMapping("/save")
	public Product saveProduct(@RequestBody Product product, @RequestBody Store store) {
		return null;
	}
	
	@PutMapping("/update/{quantity}")
	public void updateProduct(@RequestBody Product product, @RequestBody Store store, @PathVariable float quantity) {
		
	}
	
	@GetMapping("/findById/{productId}/{storeId}")
	public Product findProductById(@PathVariable short productId, @PathVariable short storeId) {
		return null;
	}
	
	@GetMapping("/findAllByStore/{storeId}")
	public List<Product> findAllProductoByStore(@PathVariable short storeId){
		return null;
	}
	
	@DeleteMapping("/delete/{productId}/{storeId}")
	public void deleteProduct(@PathVariable short productId, @PathVariable short storeId) {
		
	}
}

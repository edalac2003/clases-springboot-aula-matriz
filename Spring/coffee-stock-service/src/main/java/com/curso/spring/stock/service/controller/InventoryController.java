package com.curso.spring.stock.service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.spring.entities.lib.Inventory;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	@GetMapping("/find/{productId}/{storeId}")
	public ResponseEntity<Inventory> findInventoryByProductAndStore(
			@PathVariable short productId,
			@PathVariable short storeId) {
		
		Inventory inventory = new Inventory();
		inventory.setStock(30f);
		return new ResponseEntity<Inventory>(inventory, HttpStatus.OK);
	}
}

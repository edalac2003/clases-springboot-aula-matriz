package com.curso.spring.sales.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.curso.spring.entities.lib.Inventory;

@FeignClient(name = "stockClient", url = "${stock.service.base.url}")
public interface StockClient {

	@GetMapping("/inventory/find/{productId}/{storeId}")
	public ResponseEntity<Inventory> getInventory(@PathVariable short productId, @PathVariable short storeId);
	
}

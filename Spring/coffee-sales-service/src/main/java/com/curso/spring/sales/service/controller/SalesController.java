package com.curso.spring.sales.service.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.spring.entities.lib.Sale;
import com.curso.spring.sales.service.exceptions.AmountOfProductNotAvailableException;
import com.curso.spring.sales.service.services.ISaleService;

@RestController
@RequestMapping("/sales")
public class SalesController {

	@Autowired
	private ISaleService iSaleService;
	
	@PostMapping("/create")
	public ResponseEntity<Sale> createSale(@RequestBody Sale sale) {
		//TODO. Pendiente x realizar implementación
		try {
//			iSaleService.tryToCreateASale(sale);
//			iSaleService.tryToCreateASaleUsingWebClient(sale);
			iSaleService.tryToCreateASaleUsingOpenFeign(sale);

		} catch (AmountOfProductNotAvailableException e) {
			return new ResponseEntity<Sale>(sale, HttpStatus.NOT_ACCEPTABLE);
		}
		System.out.println("Entro info venta. " + sale);
		return new ResponseEntity<Sale>(new Sale(), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/cancel/{saleId}")
	public boolean cancelSale(@PathVariable int saleId) {
		return false;
	}
	
	@PostMapping("/invoice")
	public void generateInvoice(@RequestBody Sale sale) {
		
	}
	
	@GetMapping("/findAllByDate")
	public List<Sale> getSalesByDate(){
		return null;
	}
}

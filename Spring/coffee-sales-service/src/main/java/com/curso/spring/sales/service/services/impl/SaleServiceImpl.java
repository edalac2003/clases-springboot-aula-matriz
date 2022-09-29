package com.curso.spring.sales.service.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.curso.spring.entities.lib.Customer;
import com.curso.spring.entities.lib.Inventory;
import com.curso.spring.entities.lib.ProductToSale;
import com.curso.spring.entities.lib.Sale;
import com.curso.spring.sales.service.client.CustomerClient;
import com.curso.spring.sales.service.client.StockClient;
import com.curso.spring.sales.service.exceptions.AmountOfProductNotAvailableException;
import com.curso.spring.sales.service.services.ISaleService;

import reactor.core.publisher.Mono;

@Service
public class SaleServiceImpl implements ISaleService {

	private RestTemplate restTemplate;
	
	@Value("${stock.service.base.url}")
	private String stockServiceBaseUrl;
	
	@Value("${client.service.base.url}")
	private String clientServiceBaseUrl;
	
	@Value("${stock.service.username}")
	private String userName;
	
	@Value("${stock.service.password}")
	private String password;
	
	@Value("${client.service.usernameCreate}")
	private String userNameClientCreate;
	
	@Value("${client.service.passwordCreate}")
	private String passwordClientCreate;
	
	@Value("${client.service.usernameQuery}")
	private String userNameClientQuery;
	
	@Value("${client.service.passwordQuery}")
	private String passwordClientQuery;
	
	@Autowired
	private StockClient stockClient;
	
	@Autowired
	private CustomerClient customerClient;
	
	@Autowired
	private WebClient webClient;
	
	public SaleServiceImpl(RestTemplateBuilder restTemplateBuilder) {
		restTemplate = restTemplateBuilder.build();
	}

	@Override
	public Sale tryToCreateASale(Sale sale) throws AmountOfProductNotAvailableException {
		ResponseEntity<Inventory> availableStock = null;
		for(ProductToSale productToSale: sale.getProductsToSale()) {
			availableStock = restTemplate.exchange(stockServiceBaseUrl + "/inventory/find/{productId}/{storeId}", HttpMethod.GET, new HttpEntity<String>(createHeader(userName, password)), Inventory.class, productToSale.getProduct().getId(), 1);
			if(availableStock.getBody().getStock() < productToSale.getQuantity()) {
				throw new AmountOfProductNotAvailableException("No es posible realizar la venta por disponibilidad del producto " + productToSale.getProduct().getName());
			}
		}
		
		//Validacion del Cliente
		ResponseEntity<Customer> customerSale = restTemplate.exchange(clientServiceBaseUrl + "/client/findById/{docNumber}", HttpMethod.GET, new HttpEntity<String>(createHeader(userNameClientQuery, passwordClientQuery)), Customer.class, sale.getCustomer().getDocNumer());
		if(customerSale.getBody() == null) {
			//Si el cliente no existe, se crea
			System.out.println("El Cliente no Existe");
			customerSale = restTemplate.exchange(clientServiceBaseUrl + "/client/create", HttpMethod.POST, new HttpEntity<String>(createHeader(userNameClientCreate, passwordClientCreate)), Customer.class, sale.getCustomer());
						
			System.out.println("Se ha creado el usuario " + customerSale.getBody().getFirstName());
		}
		
		System.out.println("Venta realizada con Exito. " + sale);
		return sale;
	}

	private HttpHeaders createHeader(String userName, String password) {
		HttpHeaders httpHeaders = new HttpHeaders();
//		String auth = userName + ":" + password;
//		byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
//		String authHeader = "Basic " + new String(encodedAuth);
//		httpHeaders.add("Authorization", authHeader);
		
		httpHeaders.setBasicAuth(userName, password);
		
		return httpHeaders;
	}

	@Override
	public Sale tryToCreateASaleUsingOpenFeign(Sale sale) throws AmountOfProductNotAvailableException {
		ResponseEntity<Inventory> availableStock = null;
		for(ProductToSale productToSale: sale.getProductsToSale()) {
			availableStock = stockClient.getInventory((short)10, (short)10);
			if(availableStock.getBody().getStock() < productToSale.getQuantity()) {
				throw new AmountOfProductNotAvailableException("No es posible realizar la venta por disponibilidad del producto " + productToSale.getProduct().getName());
			}
		}
		
		
		//Validacion del Cliente
		ResponseEntity<Customer> customerSale = customerClient.getCustomerById(sale.getCustomer().getDocNumer());
		if(customerSale.getBody() == null) {
			//Si el cliente no existe, se crea
			System.out.println("El Cliente no Existe");
			customerClient.createCustomer(sale.getCustomer());
			
		}
		
		System.out.println("Venta realizada con Exito. " + sale);
		return sale;
	}

	@Override
	public Sale tryToCreateASaleUsingWebClient(Sale sale) throws AmountOfProductNotAvailableException {

		Mono<Inventory> availableStock;
		
		for(ProductToSale productToSale: sale.getProductsToSale()) {
			availableStock = webClient
					.get()
					.uri(stockServiceBaseUrl + "/inventory/find/{productId}/{storeId}", productToSale.getProduct().getId(), 10)
					.retrieve()
					.bodyToMono(Inventory.class);
			if(availableStock.block().getStock() < productToSale.getQuantity()) {
				throw new AmountOfProductNotAvailableException("No es posible realizar la venta por disponibilidad del producto " + productToSale.getProduct().getName());
			}
		}
		
		//Validacion del Cliente
		ResponseEntity<Customer> customerSale = customerClient.getCustomerById(sale.getCustomer().getDocNumer());
		if(customerSale.getBody() == null) {
			//Si el cliente no existe, se crea
			System.out.println("El Cliente no Existe");
			Mono<Customer> newCustomer = webClient
				.post()
				.uri(clientServiceBaseUrl + "/create", sale.getCustomer())
				.retrieve()
				.bodyToMono(Customer.class);
			
			System.out.println("Se ha creado el usuario " + newCustomer.block().getFirstName());
		}
		
		System.out.println("Venta realizada con Exito. " + sale);
		return sale;
	}

	
}

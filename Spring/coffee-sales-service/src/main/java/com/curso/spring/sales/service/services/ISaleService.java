package com.curso.spring.sales.service.services;

import com.curso.spring.entities.lib.Sale;
import com.curso.spring.sales.service.exceptions.AmountOfProductNotAvailableException;

public interface ISaleService {

	public Sale  tryToCreateASale(Sale sale) throws AmountOfProductNotAvailableException;
	public Sale  tryToCreateASaleUsingOpenFeign(Sale sale) throws AmountOfProductNotAvailableException;
	public Sale  tryToCreateASaleUsingWebClient(Sale sale) throws AmountOfProductNotAvailableException;
}

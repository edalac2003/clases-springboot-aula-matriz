package com.curso.spring.discount.service.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discount")
public class DiscountController {

	@GetMapping("/getByDate/{date}")
	public float getDiscountByDate(@PathVariable Date date) {
		return 0;
	}
}

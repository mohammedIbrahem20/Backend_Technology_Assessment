package com.assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.model.Bill;
import com.assessment.service.CalculateDiscountService;

@RestController
@RequestMapping("/api/calculate-discount")
public class CalculateDiscountController {

	@Autowired
	CalculateDiscountService calculateDiscountService;
	
	@PostMapping
	public ResponseEntity<String> calculateDiscount(@RequestBody Bill bill) {
		calculateDiscountService.calculateNetPayableAmount(bill);
		return ResponseEntity.ok().build();
		
	}
}

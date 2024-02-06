package com.assessment.model;

import lombok.Data;

@Data
public class Bill {

	private double totalAmount;
	private boolean isGrocery;
	private UserType userType;
}

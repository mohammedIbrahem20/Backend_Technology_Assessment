package com.assessment.service;

import org.springframework.stereotype.Service;

import com.assessment.model.Bill;
import com.assessment.model.UserType;

@Service
public class CalculateDiscountService {

	private static final double EMPLOYEE_DISCOUNT_PERCENTAGE = 0.3;
    private static final double AFFILIATE_DISCOUNT_PERCENTAGE = 0.1;
    private static final double LONG_TERM_CUSTOMER_DISCOUNT_PERCENTAGE = 0.05;
    private static final double DISCOUNT_PER_HUNDRED_DOLLARS = 5.0;

    public double calculateNetPayableAmount(Bill bill) {
        double totalAmount = bill.getTotalAmount();
        double netPayableAmount = totalAmount;

        if (!bill.isGrocery()) {
            if (bill.getUserType().equals(UserType.EMPLOYEE)) {
                netPayableAmount = applyPercentageDiscount(netPayableAmount, EMPLOYEE_DISCOUNT_PERCENTAGE);
            } else if (bill.getUserType().equals(UserType.AFFILIATE)) {
                netPayableAmount = applyPercentageDiscount(netPayableAmount, AFFILIATE_DISCOUNT_PERCENTAGE);
            } else if (bill.getUserType().equals(UserType.LONG_TERM_CUSTOMER)) {
                netPayableAmount = applyPercentageDiscount(netPayableAmount, LONG_TERM_CUSTOMER_DISCOUNT_PERCENTAGE);
            }
        }

        double discountAmount = (int) (totalAmount / 100) * DISCOUNT_PER_HUNDRED_DOLLARS;
        netPayableAmount -= discountAmount;

        return netPayableAmount;
    }

    private double applyPercentageDiscount(double amount, double discountPercentage) {
        return amount - (amount * discountPercentage);
    }
}

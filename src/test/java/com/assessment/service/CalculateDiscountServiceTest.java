package com.assessment.service;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.assessment.model.Bill;
import com.assessment.model.UserType;

@SpringBootTest
class CalculateDiscountServiceTest {

//	@Mock
//	private Bill bill;
	Bill bill;

	@Autowired
	private CalculateDiscountService discountService;

	@BeforeEach
	public void setup() {
		bill = new Bill();
	}

	@Test
    public void testCalculateNetPayableAmountForEmployeeDiscount() {
		
		bill.setGrocery(false);
		bill.setTotalAmount(100.0);
		bill.setUserType(UserType.EMPLOYEE);
		
//        when(bill.getTotalAmount()).thenReturn(100.0);
//        when(bill.isGrocery()).thenReturn(false);
//        when(bill.getUserType()).thenReturn(UserType.EMPLOYEE);

        double netPayableAmount = discountService.calculateNetPayableAmount(bill);

        Assertions.assertEquals(65.0, netPayableAmount);
    }

	@Test
    public void testCalculateNetPayableAmountForAffiliateDiscount() {
//        when(bill.getTotalAmount()).thenReturn(100.0);
//        when(bill.isGrocery()).thenReturn(false);
//        when(bill.getUserType()).thenReturn(UserType.AFFILIATE);

//		Bill bill = new Bill();
		bill.setGrocery(false);
		bill.setTotalAmount(100.0);
		bill.setUserType(UserType.AFFILIATE);
		
        double netPayableAmount = discountService.calculateNetPayableAmount(bill);

        Assertions.assertEquals(85.0, netPayableAmount);
    }

	@Test
    public void testCalculateNetPayableAmountForLongTermCustomerDiscount() {
//        when(bill.getTotalAmount()).thenReturn(100.0);
//        when(bill.isGrocery()).thenReturn(false);
//        when(bill.getUserType()).thenReturn(UserType.LONG_TERM_CUSTOMER);
		
//		Bill bill = new Bill();
		bill.setGrocery(false);
		bill.setTotalAmount(100.0);
		bill.setUserType(UserType.LONG_TERM_CUSTOMER);

        double netPayableAmount = discountService.calculateNetPayableAmount(bill);

        Assertions.assertEquals(90.0, netPayableAmount);
    }

	@Test
    public void testCalculateNetPayableAmountHundredDollarDiscount() {
//        when(bill.getTotalAmount()).thenReturn(990.0);
//        when(bill.isGrocery()).thenReturn(true);
//        when(bill.getUserType()).thenReturn(null);
		
//		Bill bill = new Bill();
		bill.setGrocery(true);
		bill.setTotalAmount(990.0);
		bill.setUserType(null);

        double netPayableAmount = discountService.calculateNetPayableAmount(bill);

        Assertions.assertEquals(945.0, netPayableAmount);
    }

	@Test
    public void testCalculateNetPayableAmountnODiscount() {
//        when(bill.getTotalAmount()).thenReturn(50.0);
//        when(bill.isGrocery()).thenReturn(true);
//		Bill bill = new Bill();
		bill.setGrocery(true);
		bill.setTotalAmount(50.0);
		bill.setUserType(null);

        double netPayableAmount = discountService.calculateNetPayableAmount(bill);

        Assertions.assertEquals(50.0, netPayableAmount);
    }

}

package com.retail_store_billing.service;

import com.retail_store_billing.entities.Bill;
import com.retail_store_billing.entities.Customer;
import com.retail_store_billing.entities.CustomerType;
import com.retail_store_billing.entities.RequestDto;

import javax.persistence.CascadeType;

public interface BillService {

//    double calculateBill(Bill bill);

    double calculateBill(RequestDto bill);

    double applyNonGroceriesDiscount(double nonGroceriesBill, long customerId);

    double applyCustomerDiscount(double nonGroceriesBill, CustomerType cascadeType);
}

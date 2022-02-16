package com.retail_store_billing.service;

import com.retail_store_billing.entities.Bill;
import com.retail_store_billing.entities.Customer;
import com.retail_store_billing.entities.CustomerType;
import com.retail_store_billing.entities.RequestDto;
import com.retail_store_billing.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    CartService cartService;

    private double discountPercentage = 0.05;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public double calculateBill(RequestDto bill) {
        Bill bill1 = Bill.builder().items(bill.getItems()).customerId(bill.getCustomerId()).build();
        double totalBill = cartService.calculateBillForAll(bill.getItems());
        double nonGroceriesBill = cartService.calculateNonGroceriesBill(bill.getItems());
        double groceriesBill = totalBill - nonGroceriesBill;
        double total = this.applyNonGroceriesDiscount(nonGroceriesBill, 1) + groceriesBill;
        int totalDiscount = (int) (total/100);
        if(totalDiscount != 0) {
            totalBill = totalDiscount * 100;
            totalBill = totalBill * discountPercentage;
            total = totalBill - total;
            totalBill += total;
        }
        return Math.abs(total);
    }

    @Override
    public double applyNonGroceriesDiscount(double nonGroceriesBill, long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        CustomerType customerType = null;

        if(customer.isPresent()) {
           customerType = customer.get().getCustomerType();
           return this.applyCustomerDiscount(nonGroceriesBill, customerType);
        }
        return 0;
    }

    @Override
    public double applyCustomerDiscount(double nonGroceriesBill, CustomerType cascadeType) {
        double discountPercentage = 0;

        switch (cascadeType) {
            case REGULAR_CUSTOMER:
                discountPercentage = 0.95;
                break;
            case AFFILIATE:
                discountPercentage = 0.90;
                break;
            case EMPLOYEE:
                discountPercentage = 0.70;
                break;
            default:
        }

        return nonGroceriesBill * discountPercentage;
    }


}

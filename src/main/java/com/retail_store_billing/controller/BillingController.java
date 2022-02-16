package com.retail_store_billing.controller;


import com.retail_store_billing.entities.Bill;
import com.retail_store_billing.entities.RequestDto;
import com.retail_store_billing.service.BillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/checkout")
public class BillingController {

    @Autowired
    BillService billService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody RequestDto bill) {
       double amount = billService.calculateBill(bill);
        return ResponseEntity.ok(amount);
    }
}

package com.retail_store_billing.entities;

import lombok.Data;

import java.util.List;

@Data
public class RequestDto {

    private String description;

    private long customerId;

    private List<CartItem> items;

}

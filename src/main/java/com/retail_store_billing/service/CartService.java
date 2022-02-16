package com.retail_store_billing.service;

import com.retail_store_billing.entities.CartItem;

import java.util.List;

public interface CartService {

    double calculateBillForAll(List<CartItem> items);

    double calculateTotalForACart(CartItem cartItem);

    double calculateNonGroceriesBill(List<CartItem> items);

    boolean isNonGroceries(long productId);
}

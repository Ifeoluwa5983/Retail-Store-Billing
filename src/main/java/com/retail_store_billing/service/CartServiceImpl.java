package com.retail_store_billing.service;

import com.retail_store_billing.entities.CartItem;
import com.retail_store_billing.entities.Product;
import com.retail_store_billing.entities.ProductType;
import com.retail_store_billing.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public double calculateBillForAll(List<CartItem> items) {
        double totalAmount = 0;

        for(CartItem ct : items) {
            totalAmount += calculateTotalForACart(ct);
        }

        return totalAmount;
    }

    @Override
    public double calculateTotalForACart(CartItem cartItem) {
        double cartAmount = 0;
        int quantity = cartItem.getQuantity();
       Optional<Product> product = productRepository.findById((long) cartItem.getProductId());

       if(product.isPresent()) {
           cartAmount = product.get().getPrice() * quantity;
       }
           return cartAmount;
    }


    @Override
    public double calculateNonGroceriesBill(List<CartItem> items) {
        double totalAmount = 0;
        List<CartItem> cartItems = new ArrayList<>();

        for(CartItem ct : items) {
            if(isNonGroceries(ct.getProductId())) {
                cartItems.add(ct);
            }
        }

        for(CartItem ct : cartItems) {
            totalAmount += calculateTotalForACart(ct);
        }

        return totalAmount;
    }

    @Override
    public boolean isNonGroceries(long productId) {
        Optional<Product> product = productRepository.findById(productId);
        if(product.isPresent()) {
            return !product.get().getProductType().equals(ProductType.GROCERIES);
        }
        return false;
    }

}

package com.retail_store_billing.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CartItemTest {

    CartItem cartItem;

    @BeforeEach
    void setUp() {
        cartItem = CartItem.builder()
                .id(1L)
                .quantity(3)
                .productId(1L)
                .bill(new Bill())
                .build();
    }

    @Test
    void getId() {
        assertThat(cartItem.getId()).isEqualTo(1L);
    }

    @Test
    void getQuantity() {
        assertThat(cartItem.getQuantity()).isEqualTo(3);
    }

    @Test
    void getProduct() {
        assertThat(cartItem.getProductId()).isEqualTo(1L);
    }

    @Test
    void getBill() {
        assertThat(cartItem.getBill()).isNotEqualTo(null);
    }

    @Test
    void setId() {
        cartItem.setId(3L);
        assertThat(cartItem.getId()).isEqualTo(3L);
    }

    @Test
    void setQuantity() {
        cartItem.setQuantity(30);
        assertThat(cartItem.getQuantity()).isEqualTo(30);
    }

    @Test
    void setProduct() {
        cartItem.setProductId(2L);
        assertThat(cartItem.getProductId()).isEqualTo(2L);
    }

    @Test
    void setBill() {
        cartItem.setBill(new Bill());
        assertThat(cartItem.getBill()).isNotEqualTo(null);
    }
}
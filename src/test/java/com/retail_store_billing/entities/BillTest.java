package com.retail_store_billing.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BillTest {

    Bill bill;

    @BeforeEach
    void setUp() {
        bill = Bill.builder()
                .customerId(1L)
                .items(new ArrayList<>())
                .description("Paid fully")
                .id(1L)
                .build();
    }

    @Test
    void getId() {
        assertThat(bill.getId()).isEqualTo(1L);
    }

    @Test
    void getDescription() {
        assertThat(bill.getDescription()).isEqualTo("Paid fully");
    }

    @Test
    void getItems() {
        assertThat(bill.getItems().size()).isEqualTo(0);
    }

    @Test
    void getCustomer() {
        assertThat(bill.getCustomerId()).isEqualTo(1L);
    }

    @Test
    void setId() {
        bill.setId(2L);
        assertThat(bill.getId()).isEqualTo(2L);
    }

    @Test
    void setDescription() {
        bill.setDescription("paid");
        assertThat(bill.getDescription()).isEqualTo("paid");
    }

    @Test
    void setItems() {
        CartItem cartItem = new CartItem();
        ArrayList<CartItem> cartItems = new ArrayList<>();
        cartItems.add(cartItem);
        bill.setItems(cartItems);
        assertThat(bill.getItems().size()).isEqualTo(1);
    }

    @Test
    void setCustomer() {
        bill.setCustomerId(2L);
        assertThat(bill.getCustomerId()).isEqualTo(2L);
    }
}
package com.retail_store_billing.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

    Store store;

    @BeforeEach
    void setUp() {
        store = Store.builder()
                .id(1L)
                .storeName("M and Q")
                .products(new ArrayList<>())
                .build();
    }

    @Test
    void getId() {
        assertThat(store.getId()).isEqualTo(1L);
    }

    @Test
    void getStoreName() {
        assertThat(store.getStoreName()).isEqualTo("M and Q");
    }

    @Test
    void getProducts() {
        assertThat(store.getProducts().size()).isEqualTo(0);
    }

    @Test
    void setId() {
        store.setId(2L);
        assertThat(store.getId()).isEqualTo(2L);
    }

    @Test
    void setStoreName() {
        store.setStoreName("Ife's store");
        assertThat(store.getStoreName()).isEqualTo("Ife's store");
    }

    @Test
    void setProducts() {
        Product product = new Product();
        List<Product> products = new ArrayList<>();
        products.add(product);
        store.setProducts(products);
        assertThat(store.getProducts().size()).isEqualTo(1);

    }
}
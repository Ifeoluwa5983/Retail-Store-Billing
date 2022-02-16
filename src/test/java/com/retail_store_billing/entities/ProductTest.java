package com.retail_store_billing.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product product;

    @BeforeEach
    void setUp() {
        product = Product.builder()
                .id(1L)
                .price(300.00)
                .productName("Bobo")
                .productType(ProductType.GROCERIES)
                .build();
    }

    @Test
    void getId() {
        assertThat(product.getId()).isEqualTo(1L);
    }

    @Test
    void getProductName() {
        assertThat(product.getProductName()).isEqualTo("Bobo");
    }

    @Test
    void getProductType() {
        assertThat(product.getProductType()).isEqualTo(ProductType.GROCERIES);
    }

    @Test
    void getPrice() {
        assertThat(product.getPrice()).isEqualTo(300.00);
    }


    @Test
    void setId() {
        product.setId(2L);
        assertThat(product.getId()).isEqualTo(2L);
    }

    @Test
    void setProductName() {
        product.setProductName("Zobo");
        assertThat(product.getProductName()).isEqualTo("Zobo");
    }

    @Test
    void setProductType() {
        product.setProductType(ProductType.MEDIA);
        assertThat(product.getProductType()).isEqualTo(ProductType.MEDIA);
    }

    @Test
    void setPrice() {
        product.setPrice(50.00);
        assertThat(product.getPrice()).isEqualTo(50.00);
    }

}
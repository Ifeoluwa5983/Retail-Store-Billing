package com.retail_store_billing.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    Customer customer;

    @BeforeEach
    void setUp() {
        customer = Customer.builder()
                .id(1L)
                .firstName("Ifeoluwa")
                .lastName("Oluwafemi")
                .phoneNumber("09087654321")
                .customerType(CustomerType.EMPLOYEE)
                .build();
    }

    @Test
    void getId() {
        assertThat(customer.getId()).isEqualTo(1L);
    }

    @Test
    void getFirstName() {
        assertThat(customer.getFirstName()).isEqualTo("Ifeoluwa");
    }

    @Test
    void getLastName() {
        assertThat(customer.getLastName()).isEqualTo("Oluwafemi");
    }

    @Test
    void getPhoneNumber() {
        assertThat(customer.getPhoneNumber()).isEqualTo("09087654321");
    }

    @Test
    void getCustomerType() {
        assertThat(customer.getCustomerType()).isEqualTo(CustomerType.EMPLOYEE);
    }


    @Test
    void setId() {
        customer.setId(2L);
        assertThat(customer.getId()).isEqualTo(2L);
    }

    @Test
    void setFirstName() {
        customer.setFirstName("Ife");
        assertThat(customer.getFirstName()).isEqualTo("Ife");
    }

    @Test
    void setLastName() {
        customer.setLastName("Femi");
        assertThat(customer.getLastName()).isEqualTo("Femi");
    }

    @Test
    void setPhoneNumber() {
        customer.setPhoneNumber("080987654321");
        assertThat(customer.getPhoneNumber()).isEqualTo("080987654321");
    }

    @Test
    void setCustomerType() {
        customer.setCustomerType(CustomerType.REGULAR_CUSTOMER);
        assertThat(customer.getCustomerType()).isEqualTo(CustomerType.REGULAR_CUSTOMER);
    }

}
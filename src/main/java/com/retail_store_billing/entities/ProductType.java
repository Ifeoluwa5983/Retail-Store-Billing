package com.retail_store_billing.entities;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ProductType {
    GROCERIES("GROCERIES"),
    GADGETS("GADGETS"),
    MEDIA("MEDIA");

    public final String status;

    ProductType(String status){
        this.status = status;
    }

    @JsonValue
    public String getStatus() {
        return status;
    }
}

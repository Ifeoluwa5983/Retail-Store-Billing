package com.retail_store_billing.entities;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CustomerType {

    EMPLOYEE("EMPLOYEE"),
    AFFILIATE("AFFILIATE"),
    REGULAR_CUSTOMER("REGULAR CUSTOMER");

    public final String status;

    CustomerType(String status){
        this.status = status;
    }

    @JsonValue
    public String getStatus() {
        return status;
    }
}

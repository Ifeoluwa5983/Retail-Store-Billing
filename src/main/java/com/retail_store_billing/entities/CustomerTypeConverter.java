package com.retail_store_billing.entities;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class CustomerTypeConverter implements AttributeConverter<CustomerType, String> {

    @Override
    public String convertToDatabaseColumn(CustomerType customerType) {
        if(customerType == null) {
            return null;
        }
        return customerType.getStatus();
    }

    @Override
    public CustomerType convertToEntityAttribute(String dbData) {
        if(dbData == null) {
            return null;
        }
        return Stream.of(CustomerType.values())
                .filter(s -> s.getStatus().equals(dbData))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);    }
}

package com.retail_store_billing.entities;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class ProductTypeConverter implements AttributeConverter<ProductType, String> {

    @Override
    public String convertToDatabaseColumn(ProductType productType) {
        if(productType == null) {
            return null;
        }
        return productType.getStatus();
    }

    @Override
    public ProductType convertToEntityAttribute(String dbData) {
        if(dbData == null) {
            return null;
        }
        return Stream.of(ProductType.values())
                .filter(s -> s.getStatus().equals(dbData))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

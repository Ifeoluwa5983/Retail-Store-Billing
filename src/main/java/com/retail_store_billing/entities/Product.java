package com.retail_store_billing.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;

    private ProductType productType;

    private Double price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    private Store store;
}

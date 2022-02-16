package com.retail_store_billing.repositories;

import com.retail_store_billing.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    StoreRepository storeRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CartItemRepository cartItemRepository;




    @Override
    public void run(String... args) throws Exception {

        Store store = Store.builder().storeName("Ife's Store").build();
        store = storeRepository.save(store);

        Product product = Product.builder().productType(ProductType.GROCERIES).productName("food").price(10.0).store(store).build();
        Product product2 = Product.builder().productType(ProductType.GADGETS).productName("phone").price(356.0).store(store).build();
        Product product3 = Product.builder().productType(ProductType.MEDIA).productName("disk").price(1000.0).store(store).build();

        List<Product> productList = new ArrayList<>();

        productList.add(product);
        productList.add(product2);
        productList.add(product3);
        store.setProducts(productList);
        store = storeRepository.save(store);



        CartItem cartItem = CartItem.builder().productId(1L).quantity(20).build();
        cartItemRepository.save(cartItem);

        Customer customer = Customer.builder().customerType(CustomerType.REGULAR_CUSTOMER).firstName("Ife").build();
        Customer customer2 = Customer.builder().customerType(CustomerType.REGULAR_CUSTOMER).firstName("Gideon").build();
        Customer customer3 = Customer.builder().customerType(CustomerType.REGULAR_CUSTOMER).firstName("Kola").build();
        customerRepository.save(customer);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
    }
}

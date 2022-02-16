package com.retail_store_billing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableWebMvc
@EnableSwagger2
@SpringBootApplication
public class RetailStoreBillingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailStoreBillingApplication.class, args);
	}

}

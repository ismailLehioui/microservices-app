package org.enicar.billingservice;

import org.enicar.billingservice.entities.Bill;
import org.enicar.billingservice.entities.ProductItem;
import org.enicar.billingservice.feign.CustomerRestClient;
import org.enicar.billingservice.feign.ProductRestClient;
import org.enicar.billingservice.model.Customer;
import org.enicar.billingservice.model.Product;
import org.enicar.billingservice.repository.BillRepository;
import org.enicar.billingservice.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BillRepository billRepository,
                                        ProductItemRepository productItemRepository,
                                        CustomerRestClient customerRestClient,
                                        ProductRestClient productRestClient) {

        return args -> {
            Collection<Customer> customers = customerRestClient.getAllcustomers().getContent();
            Collection<Product> products = productRestClient.getAllProducts().getContent();

            customers.forEach(customer -> {
                Bill bill = Bill.builder()
                        .billDate(new Date())
                        .customerId(customer.getId())
                        .build();
                billRepository.save(bill);

                products.forEach(product -> {
                    ProductItem productItem = ProductItem.builder()
                            .bill(bill)
                            .productId(product.getId())
                            .quantity(1+new Random().nextInt(9))
                            .unitPrice(product.getPrice())
                            .build();
                    productItemRepository.save(productItem);
                });

            });
        };
    }
}

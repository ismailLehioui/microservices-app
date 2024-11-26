package org.enicar.inventoryservice;

import org.enicar.inventoryservice.entities.Product;
import org.enicar.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Lunette")
                    .price(2323)
                    .quantity(3)
                    .build());
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("casque")
                    .price(2323)
                    .quantity(1)
                    .build());
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("telephone")
                    .price(1000)
                    .quantity(1)
                    .build());
            productRepository.findAll().forEach(p -> {
                System.out.println(p.toString());
                /*System.out.println("=======================");
                System.out.println(c.getId());
                System.out.println(c.getName());
                System.out.println(c.getPrice());
                System.out.println(c.getQuantity());
                System.out.println("=======================");*/
            });
        };
    }
}

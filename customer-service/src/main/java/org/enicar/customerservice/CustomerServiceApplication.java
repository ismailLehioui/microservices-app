package org.enicar.customerservice;

import org.enicar.customerservice.entities.Customer;
import org.enicar.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(Customer.builder()
                            .name("ismail")
                            .email("ismail@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("maher")
                    .email("maher@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("khaled")
                    .email("khaled@gmail.com")
                    .build());
            customerRepository.findAll().forEach(c-> {
                System.out.println("=======================");
                System.out.println(c.getId());
                System.out.println(c.getName());
                System.out.println(c.getEmail());
                System.out.println("=======================");
            });
        };

    }

}

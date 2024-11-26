package org.enicar.billingservice.feign;

import jakarta.ws.rs.GET;
import org.enicar.billingservice.model.Customer;
import org.enicar.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerRestClient {
    @GetMapping("/api/customers/{id}")
    Customer getCustomerById(@PathVariable Long id);
    @GetMapping("/api/customers")
    PagedModel<Customer> getAllcustomers();
}
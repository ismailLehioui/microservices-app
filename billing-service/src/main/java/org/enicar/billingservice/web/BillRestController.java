package org.enicar.billingservice.web;

import org.enicar.billingservice.entities.Bill;
import org.enicar.billingservice.feign.CustomerRestClient;
import org.enicar.billingservice.repository.BillRepository;
import org.enicar.billingservice.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {
    @Autowired
    BillRepository billRepo;
    @Autowired
    CustomerRestClient customerRestClient;
    @Autowired
    ProductItemRepository productItemRepo;
    @GetMapping(path = "bills/{id}")
    public Bill getBill(@PathVariable Long id) {
        Bill bill = billRepo.findById(id).get();
        bill.setCustomer(customerRestClient.getCustomerById(bill.getCustomerId())) ;
        //bill.setCustomer(customerRestClient.getCustomerById(bill.getCustomerId())) ;
        return bill;
    }
}

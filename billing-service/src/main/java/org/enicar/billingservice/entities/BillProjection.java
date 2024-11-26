package org.enicar.billingservice.entities;

import org.enicar.billingservice.model.Customer;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;
import java.util.List;

@Projection(name = "allProj", types = Bill.class)
public interface BillProjection {
    Long getId(); // Expose l'ID du Bill
    String getBillType(); // Expose le type de facture
    Date getBillDate(); // Expose la date de facture
    Long getCustomerId(); // Expose l'ID du client associé
    List<ProductItem> getProductItems(); // Expose la liste des produits liés à la facture
    Customer getCustomer(); // Expose les détails du client (Transient, mais utile dans l'API REST)
}

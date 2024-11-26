package org.enicar.customerservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "emailProj", types = Customer.class)
public interface CustomerProjectionEmail {
    //pour selectionner les attributs à recuperer (comme graphQL)
    //exp: http://localhost:9091/customers/1?projection=emailProj
    String getEmail();
}

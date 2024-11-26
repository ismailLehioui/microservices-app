package org.enicar.customerservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "allProj", types = Customer.class)
public interface CustomerProjection {
    String getFirstName();
    String getLastName();
}

package org.gs.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.gs.entity.CustomerTblT;

@ApplicationScoped
public class CustomerTblTRepo implements PanacheRepository<CustomerTblT> {
}

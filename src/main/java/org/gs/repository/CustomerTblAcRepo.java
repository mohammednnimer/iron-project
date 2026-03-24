package org.gs.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.gs.entity.CustomerTblAc;

@ApplicationScoped
public class CustomerTblAcRepo implements PanacheRepository<CustomerTblAc> {
}

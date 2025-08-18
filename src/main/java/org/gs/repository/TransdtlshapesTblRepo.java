package org.gs.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.gs.entity.TransdtlshapesTbl;

@ApplicationScoped
public class TransdtlshapesTblRepo implements PanacheRepository<TransdtlshapesTbl> {
}

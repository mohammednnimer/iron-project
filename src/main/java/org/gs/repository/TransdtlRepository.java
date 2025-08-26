package org.gs.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.gs.entity.TransdtlTbl;

@ApplicationScoped
public class TransdtlRepository implements PanacheRepository<TransdtlTbl> {
}

package org.gs.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.gs.entity.EmpDailymovesTbl;

@ApplicationScoped
public class EmpDailymovesTblRepo implements PanacheRepository<EmpDailymovesTbl> {
}

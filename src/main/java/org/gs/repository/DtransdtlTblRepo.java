package org.gs.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.gs.entity.DtransdtlTbl;

@ApplicationScoped
public class DtransdtlTblRepo implements PanacheRepository<DtransdtlTbl> {
}

package org.gs.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.gs.entity.DtranshdrTbl;

@ApplicationScoped
public class DtranshdrTblRepo implements PanacheRepository<DtranshdrTbl> {
}

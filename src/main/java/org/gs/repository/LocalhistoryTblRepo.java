package org.gs.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.gs.entity.LocalhistoryTbl;

@ApplicationScoped
public class LocalhistoryTblRepo implements PanacheRepository<LocalhistoryTbl> {
}

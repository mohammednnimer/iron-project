package org.gs.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.gs.entity.TranshdrTbl;

@ApplicationScoped
public class TranshdrTblRepo implements PanacheRepository<TranshdrTbl> {
}

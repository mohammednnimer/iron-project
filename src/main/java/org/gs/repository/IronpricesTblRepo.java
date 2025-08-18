package org.gs.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.gs.entity.IronpricesTbl;

@ApplicationScoped
public class IronpricesTblRepo implements PanacheRepository<IronpricesTbl> {
}

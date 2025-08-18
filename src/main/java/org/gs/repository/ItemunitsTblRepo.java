package org.gs.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.gs.entity.ItemunitsTbl;

@ApplicationScoped
public class ItemunitsTblRepo implements PanacheRepository<ItemunitsTbl> {
}

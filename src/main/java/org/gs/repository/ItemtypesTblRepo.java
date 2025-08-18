package org.gs.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.gs.entity.ItemtypesTbl;

@ApplicationScoped
public class ItemtypesTblRepo implements PanacheRepository<ItemtypesTbl> {
}

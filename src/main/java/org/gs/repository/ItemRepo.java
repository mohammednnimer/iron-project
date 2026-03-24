package org.gs.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.gs.entity.Item;

@ApplicationScoped
public class ItemRepo implements PanacheRepository<Item> {
}

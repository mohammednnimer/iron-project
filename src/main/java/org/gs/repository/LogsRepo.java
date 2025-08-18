package org.gs.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.gs.entity.Logs;

@ApplicationScoped
public class LogsRepo implements PanacheRepository<Logs> {
}

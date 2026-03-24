package org.gs.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.gs.entity.RemotehistoryTbl;

@ApplicationScoped
public class RemotehistoryTblRepo implements PanacheRepository<RemotehistoryTbl> {
}

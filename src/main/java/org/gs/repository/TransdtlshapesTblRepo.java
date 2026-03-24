package org.gs.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.gs.entity.TransdtlTbl;
import org.gs.entity.TransdtlshapesTbl;

import java.util.List;

@ApplicationScoped
public class TransdtlshapesTblRepo implements PanacheRepository<TransdtlshapesTbl> {

    public TransdtlshapesTbl findBytransKey(String key)
    {
        return find("txtTranskey = ?1",key).firstResult();
    }

}

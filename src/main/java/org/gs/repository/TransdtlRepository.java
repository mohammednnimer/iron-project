package org.gs.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.gs.entity.TransdtlTbl;

import java.util.List;

@ApplicationScoped
public class TransdtlRepository implements PanacheRepository<TransdtlTbl> {

    public List<TransdtlTbl> findByHeaderKey(String key)
    {
       return find("txtHdrkey = ?1",key).list();
    }
}

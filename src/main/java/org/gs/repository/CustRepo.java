package org.gs.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.gs.entity.Cust;
import org.gs.entity.UsersTbl;

import java.util.List;

@ApplicationScoped
public class CustRepo implements PanacheRepository<Cust> {



    public Cust findByReference(String reference) {
        return find("reference = ?1", reference).firstResult();
    }





    public List<Cust> GetAllCust(int limit, int page) {
        int offset = (page-1) * limit;
        return findAll().range(offset,offset+ limit - 1).list();
    }

}

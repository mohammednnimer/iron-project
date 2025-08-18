package org.gs.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.gs.entity.CustomerTbl;
import org.gs.entity.UsersTbl;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CustomerTblRepo implements PanacheRepository<CustomerTbl> {

//    public CustomerTbl findById(String txtKey) {
//        return find("txtKey = ?1", txtKey).firstResult();
//    }

    public List<CustomerTbl> findByName(String txtName) {
        return find("LOWER(txtName) LIKE ?1", "%" + txtName.toLowerCase() + "%").list();
    }

    public CustomerTbl findByReference(String txtReference) {
        return find("LOWER(txtReference) = ?1", txtReference.toLowerCase()).firstResult();
    }

    public List<CustomerTbl> findByPartOfReference(String txtReference) {
        return find("LOWER(txtReference) LIKE ?1", "%" + txtReference.toLowerCase() + "%").list();
    }


    public List<CustomerTbl> GetAllCustomer(int limit, int page) {
        int offset = (page-1) * limit;
        return findAll().range(offset,offset+ limit - 1).list();

    }

    public List<CustomerTbl> search(String generalSearch,int limit,int page ) {
        String query = "1 = 1";

        if (generalSearch != null && !generalSearch.trim().isEmpty()) {
            String[] terms = generalSearch.trim().split("\\s+");
            for (String term : terms) {
                String lowerTerm = term.toLowerCase();
                query += " AND ("
                        + "LOWER(txtName) LIKE '%" + lowerTerm + "%' OR "
                        + "LOWER(txtPhone1) LIKE '%" + lowerTerm + "%' OR "
                        + "LOWER(txtPhone2) LIKE '%" + lowerTerm + "%' OR "
                        + "LOWER(txtAddress) LIKE '%" + lowerTerm + "%' OR "
                        + "LOWER(txtReference) LIKE '%" + lowerTerm + "%' OR "
                        + "LOWER(txtEmail) LIKE '%" + lowerTerm + "%'"
                        + ")";
            }
        }

        query += " ORDER BY txtName ASC";
        int offset = (page-1) * limit;
        return find(query).range(offset,offset+ limit - 1).list();

    }



}


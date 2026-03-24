package org.gs.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.gs.entity.IrontypesTbl;
import org.gs.entity.ItemtypesTbl;

import java.math.BigDecimal;
import java.util.List;

@ApplicationScoped
public class ItemtypesTblRepo implements PanacheRepository<ItemtypesTbl> {
        public ItemtypesTbl findByReference(String txtReference) {
        return find("txtReference ",  txtReference ).firstResult();
       }
    public ItemtypesTbl findByKey(String key) {
        return find("txtKey ",  key ).firstResult();
    }

        public List<ItemtypesTbl> findBypartofReference(String txtReference) {
        return find("txtReference LIKE ?1", "%" + txtReference + "%").list();
    }
        public List<ItemtypesTbl> findbyprice(BigDecimal from ,BigDecimal to, int limit, int page) {
        int offset = (page-1) * limit;
        return find("dblPrice >= ?1 and dblPrice <= ?2", from, to)
                .range(offset, offset + limit - 1)
                .list();
    }
        public List<ItemtypesTbl> GetAllIrinType(int limit, int page) {
        int offset = (page-1) * limit;
        return findAll().range(offset,offset+ limit - 1).list();
    }
        public List<ItemtypesTbl> search(String generalSearch, int limit, int page) {
        String query = "1 = 1";

        if (generalSearch != null && !generalSearch.trim().isEmpty()) {
            String[] terms = generalSearch.trim().split("\\s+");
            for (String term : terms) {
                String lowerTerm = term.toLowerCase();
                query += " AND ("
                        + "LOWER(txtDescription) LIKE '%" + lowerTerm + "%' OR "
                        + "LOWER(txtReference) LIKE '%" + lowerTerm + "%'";

                if (term.matches("\\d+")) {
                    query += " OR CONCAT('', dblPrice) LIKE '%" + term + "%'";
                }
                query += ")";  }
        }

        int offset = (page - 1) * limit;
        return find(query).range(offset, offset + limit - 1).list();
    }
    }


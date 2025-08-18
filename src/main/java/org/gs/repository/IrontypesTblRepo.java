package org.gs.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.gs.entity.IronshapesTbl;
import org.gs.entity.IrontypesTbl;
import org.gs.entity.UsersTbl;

import java.util.List;

@ApplicationScoped
public class IrontypesTblRepo implements PanacheRepository<IrontypesTbl> {


    public IrontypesTbl findByReference(String txtReference) {
        return find("txtReference ",  txtReference ).firstResult();
    }

    public List<IrontypesTbl> findBypartofReference(String txtReference) {
        return find("txtReference LIKE ?1", "%" + txtReference + "%").list();
    }


    public List<IrontypesTbl> GetAllIrinType(int limit, int page) {
        int offset = (page-1) * limit;
        return findAll().range(offset,offset+ limit - 1).list();
    }
    public List<IrontypesTbl> search(String generalSearch, int limit, int page) {
        String query = "1 = 1";

        if (generalSearch != null && !generalSearch.trim().isEmpty()) {
            String[] terms = generalSearch.trim().split("\\s+");
            for (String term : terms) {
                String lowerTerm = term.toLowerCase();
                query += " AND ("
                        + "LOWER(txtDescription) LIKE '%" + lowerTerm + "%' OR "
                        + "LOWER(txtReference) LIKE '%" + lowerTerm + "%'";

                if (term.matches("\\d+")) {
                    query += " OR CONCAT('', intNum) LIKE '%" + term + "%'";
                }
                if (term.matches("\\d+")) {
                    query += " OR CONCAT('', dblWeightpergram) LIKE '%" + term + "%'";
                }

                if (term.matches("\\d+")) {
                    query += " OR CONCAT('', dblPrice) LIKE '%" + term + "%'";
                }


                query += ")";  }
        }

        int offset = (page - 1) * limit;
        return find(query).range(offset, offset + limit - 1).list();
    }
}

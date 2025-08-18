package org.gs.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.gs.entity.CustomerTbl;
import org.gs.entity.IronshapesTbl;
import org.gs.entity.IrontypesTbl;
import org.gs.entity.UsersTbl;

import java.util.List;

@ApplicationScoped
public class IronshapesTblRepo implements PanacheRepository<IronshapesTbl> {


    public List<IronshapesTbl> GetAllUser(int limit, int page) {
        int offset = (page-1) * limit;
        return findAll().range(offset,offset+ limit - 1).list();
    }
    public IronshapesTbl findByReference(String txtReference) {
        return find("txtReference ",  txtReference ).firstResult();
    }


    public List<IronshapesTbl> findByPartOfReference(String txtReference) {
        return find("LOWER(txtReference) LIKE ?1", "%" + txtReference.toLowerCase() + "%").list();
    }

    public List<IronshapesTbl> search(String generalSearch, int limit, int page) {
        String query = "1 = 1";

        if (generalSearch != null && !generalSearch.trim().isEmpty()) {
            String[] terms = generalSearch.trim().split("\\s+");
            for (String term : terms) {
                String lowerTerm = term.toLowerCase();
                query += " AND ("
                        + "LOWER(txtDescription) LIKE '%" + lowerTerm + "%' OR "
                        + "LOWER(txtReference) LIKE '%" + lowerTerm + "%'";

                if (term.matches("\\d+")) {
                    query += " OR CONCAT('', intSides) LIKE '%" + term + "%'";
                }

                query += ")";  }
        }

        int offset = (page - 1) * limit;
        return find(query).range(offset, offset + limit - 1).list();
    }
}

package org.gs.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.gs.entity.CustomerTbl;
import org.gs.entity.IrondepthTbl;
import org.gs.entity.IronshapesTbl;

import java.util.List;

@ApplicationScoped
public class IrondepthTblRepo implements PanacheRepository<IrondepthTbl> {
    public List<IrondepthTbl> findByPartOfReference(String txtReference) {
        return find("LOWER(txtReference) LIKE ?1", "%" + txtReference.toLowerCase() + "%").list();


    }



    public IrondepthTbl findByKey(String txtKey) {
        return find("LOWER(txtKey) = ?1", txtKey.toLowerCase()).firstResult();
    }

    public IrondepthTbl findByReference(String txtReference) {
        return find("LOWER(txtReference) = ?1", txtReference.toLowerCase()).firstResult();
    }

    public List<IrondepthTbl> search(String generalSearch, int limit, int page) {
        String query = "1 = 1";

        if (generalSearch != null && !generalSearch.trim().isEmpty()) {
            String[] terms = generalSearch.trim().split("\\s+");
            for (String term : terms) {
                String lowerTerm = term.toLowerCase();
                query += " AND ("
                        + "LOWER(txtDescription) LIKE '%" + lowerTerm + "%' OR "
                        + "LOWER(txtReference) LIKE '%" + lowerTerm + "%'";

                if (term.matches("\\d+")) {
                    query += " OR CONCAT('', dblWeight) LIKE '%" + term + "%'";
                }

                query += ")";  }
        }

        int offset = (page - 1) * limit;
        return find(query).range(offset, offset + limit - 1).list();
    }
}

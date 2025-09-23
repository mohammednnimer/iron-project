package org.gs.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.gs.entity.DocumentsTbl;

import java.util.List;

@ApplicationScoped
public class DocumentsTblRepo implements PanacheRepository<DocumentsTbl> {
    public List<DocumentsTbl> findBytxtHdr(String txtKey) {
        return find("LOWER(txtHdrkey) = ?1", txtKey.toLowerCase()).list();
    }
}

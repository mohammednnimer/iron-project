package org.gs.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.gs.entity.Cust;
import org.gs.repository.CustRepo;

import java.util.List;

@ApplicationScoped
public class CustService {

    @Inject
    CustRepo custRepo;

    @Transactional
    public boolean create(Cust cust) {
        if (custRepo.findByReference(cust.getReference()) != null) {
            return false;
        }
        custRepo.persist(cust);
        return true;
    }


    @Transactional
    public boolean update(Cust updatedCust) {
        Cust cust = custRepo.findByReference(updatedCust.getReference());
        if (cust == null) {
            return false;
        }
        if (updatedCust.getDescription() != null) {
            cust.setDescription(updatedCust.getDescription());
        }
        if (updatedCust.getTel() != null) {
            cust.setTel(updatedCust.getTel());
        }
        return true;
    }


    public Cust searchByReference(String reference) {
        if (custRepo.findByReference(reference) == null) {
            return null;
        }
        return custRepo.findByReference(reference);
    }
    public List<Cust> listAll(int limit, int page) {

        return  custRepo.GetAllCust(limit,page);
    }





}

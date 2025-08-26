package org.gs.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.QueryParam;
import org.gs.entity.CustomerTbl;
import org.gs.entity.IrondepthTbl;
import org.gs.repository.CustomerTblRepo;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class CustomerTblService {

    @Inject
    CustomerTblRepo customerTblRepo;
    @Transactional
    public boolean add(CustomerTbl customer) {
        if (customerTblRepo.findByReference(customer.getTxtReference()) != null) {
            return false;
        }
        customer.setTxtKey(UUID.randomUUID().toString());
        customerTblRepo.persist(customer);
        return true;
    }
    @Transactional
    public boolean update(CustomerTbl updatedCustomer) {
        CustomerTbl existing = customerTblRepo.findByReference(updatedCustomer.getTxtReference());
        if (existing == null) {
            return false;
        }
        if (updatedCustomer.getTxtTag() != null) existing.setTxtTag(updatedCustomer.getTxtTag());
        if (updatedCustomer.getTxtName() != null) existing.setTxtName(updatedCustomer.getTxtName());
        if (updatedCustomer.getTxtPhone1() != null) existing.setTxtPhone1(updatedCustomer.getTxtPhone1());
        if (updatedCustomer.getTxtPhone2() != null) existing.setTxtPhone2(updatedCustomer.getTxtPhone2());
        if (updatedCustomer.getTxtAddress() != null) existing.setTxtAddress(updatedCustomer.getTxtAddress());
        if (updatedCustomer.getTxtTest() != null) existing.setTxtTest(updatedCustomer.getTxtTest());
        if (updatedCustomer.getIntSystemtype() != null) existing.setIntSystemtype(updatedCustomer.getIntSystemtype());
        if (updatedCustomer.getTxtEmail() != null) existing.setTxtEmail(updatedCustomer.getTxtEmail());
        return true;
    }

    public List<CustomerTbl> searchByTxtName(String txtName) {
        return customerTblRepo.findByName(txtName);
    }
    public List<CustomerTbl> searchByTxtRefrences(String txtKey) {
        return customerTblRepo.findByPartOfReference(txtKey);
    }

    public List<CustomerTbl> listAll( int limit ,  int page) {
        return customerTblRepo.GetAllCustomer(limit,page);
    }

    public List<CustomerTbl> search(String GenralSearch, int limit ,int page)
    {
    return customerTblRepo.search(GenralSearch,limit,page);
    }


    @Transactional
    public boolean deleteByReference(String txtReference) {
        CustomerTbl existing = customerTblRepo.findByReference(txtReference);
        if (existing != null) {
            customerTblRepo.delete(existing);
            return true;
        }
        return false;
    }
}

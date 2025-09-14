package org.gs.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.gs.dto.IronTypes;
import org.gs.entity.IrontypesTbl;
import org.gs.entity.ItemtypesTbl;
import org.gs.repository.IrontypesTblRepo;
import org.gs.repository.ItemtypesTblRepo;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class ItemTypeService {

    @Inject
    ItemtypesTblRepo repo;

    @Transactional
    public boolean create(ItemtypesTbl iron) {

        ItemtypesTbl irontypesTbl=repo.findByReference(iron.getTxtReference());
        if(irontypesTbl==null)
        {if (iron.getTxtKey() == null || iron.getTxtKey().isBlank()) {
            iron.setTxtKey(UUID.randomUUID().toString());
        }
            repo.persist(iron);

            return true;

        }
        else{
            return false;
        }


    }

//    @Transactional
//    public boolean update(IrontypesTbl updated) {
//        IrontypesTbl existing = repo.findByTxtKey(updated.getTxtKey());
//        if (existing == null) {
//            return false;
//        }
//        if (updated.getTxtDescription() != null) existing.setTxtDescription(updated.getTxtDescription());
//        if (updated.getIntNum() != null) existing.setIntNum(updated.getIntNum());
//        if (updated.getDblWeightpergram() != null) existing.setDblWeightpergram(updated.getDblWeightpergram());
//        if (updated.getTxtReference() != null) existing.setTxtReference(updated.getTxtReference());
//        if (updated.getDblPrice() != null) existing.setDblPrice(updated.getDblPrice());
//        return true;
//    }

    @Transactional
    public boolean deleteByReference(String txtReference) {
        ItemtypesTbl existing = repo.findByReference(txtReference);
        if (existing != null) {
            repo.delete(existing);
            return true;
        }
        return false;
    }



    public ItemtypesTbl searchByrefrences(String txtKey) {
        return repo.findByReference(txtKey);
    }

    public ItemtypesTbl searchByTxtKey(String txtKey) {
        return repo.findByKey(txtKey);
    }


    public List<ItemtypesTbl> search(String GenralSearch, int limit , int page)
    {
        return repo.search(GenralSearch,limit,page);
    }
    public List<ItemtypesTbl> searchbyPrice(BigDecimal from , BigDecimal to, int limit, int page)
    {
        return repo.findbyprice(from,to,limit,page);
    }




    @Transactional
    public boolean updatebyrefrences(ItemtypesTbl updated) {

        System.out.println(1);
        ItemtypesTbl existing = repo.findByReference(updated.getTxtReference());
        System.out.println(2);
        if (existing == null) {
            return false;
        }
        System.out.println(3);

        if (updated.getTxtDescription() != null) existing.setTxtDescription(updated.getTxtDescription());
        if (updated.getDblPrice() != null) existing.setDblPrice(updated.getDblPrice());
        return true;
    }

    public List<ItemtypesTbl> listAll(int limit, int page) {
        return repo.GetAllIrinType( limit,  page);
    }
}

package org.gs.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.gs.entity.IrondepthTbl;
import org.gs.entity.IronshapesTbl;
import org.gs.repository.IrondepthTblRepo;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class IrondepthService {

    @Inject
    IrondepthTblRepo irondepthTblRepo;

    @Transactional
    public boolean create(IrondepthTbl iron) {
        IrondepthTbl existing = irondepthTblRepo.findByReference(iron.getTxtReference());
        if (existing != null) {
            return false;
        }

        if (iron.getTxtKey() == null || iron.getTxtKey().isBlank()) {
            iron.setTxtKey(UUID.randomUUID().toString().substring(0, 30));
        }

        irondepthTblRepo.persist(iron);
        return true;
    }

    public List<IrondepthTbl> getAll(int limit, int page) {
        int offset = (page - 1) * limit;
        return irondepthTblRepo.findAll().range(offset, offset + limit - 1).list();
    }

    public List<IrondepthTbl> getByReference(String txtReference) {
        return irondepthTblRepo.findByPartOfReference(txtReference);
    }

    public List<IrondepthTbl> search(String GenralSearch, int limit , int page)
    {
        return irondepthTblRepo.search(GenralSearch,limit,page);
    }


    @Transactional
    public boolean updateByReference(IrondepthTbl updated) {
        IrondepthTbl existing = irondepthTblRepo.findByReference(updated.getTxtReference());
        if (existing == null) {
            return false;
        }
        if (updated.getTxtDescription() != null) existing.setTxtDescription(updated.getTxtDescription());
        if (updated.getDblWeight() != null) existing.setDblWeight(updated.getDblWeight());

        return true;
    }
}

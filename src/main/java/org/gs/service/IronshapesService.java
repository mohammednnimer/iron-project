package org.gs.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.gs.dto.IronTypes;
import org.gs.entity.CustomerTbl;
import org.gs.entity.IronshapesTbl;
import org.gs.entity.IrontypesTbl;
import org.gs.repository.IronshapesTblRepo;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class IronshapesService {

    @Inject
    IronshapesTblRepo ironshapesTblRepo;
    @Transactional
    public boolean create(IronshapesTbl iron) {

        IronshapesTbl irontypesTbl=ironshapesTblRepo.findByReference(iron.getTxtReference());
        if(irontypesTbl==null)
        {if (iron.getTxtKey() == null || iron.getTxtKey().isBlank()) {
            iron.setTxtKey(UUID.randomUUID().toString().substring(0,30));
        }
            ironshapesTblRepo.persist(iron);
            return true;
        }
        else{
            return false;
        }
    }

    @Transactional
    public boolean updateByReference(IronshapesTbl updated) {
        IronshapesTbl existing = ironshapesTblRepo.findByReference(updated.getTxtReference());
        if (existing == null) {
            return false;
        }
        if (updated.getTxtDescription() != null) existing.setTxtDescription(updated.getTxtDescription());
        if (updated.getImgImage() != null) existing.setImgImage(updated.getImgImage());
        if (updated.getIntSides() != null) existing.setIntSides(updated.getIntSides());
        if (updated.getTxtIronkey() != null) existing.setTxtIronkey(updated.getTxtIronkey());
        return true;
    }
    public List<IronshapesTbl> getAll(int limit, int page) {
        return ironshapesTblRepo.GetAllUser(limit, page);
    }
    public List<IronshapesTbl> getByReference(String txtReference) {
        return ironshapesTblRepo.findByPartOfReference(txtReference);
    }

    public List<IronshapesTbl> search(String GenralSearch, int limit , int page)
    {
        return ironshapesTblRepo.search(GenralSearch,limit,page);
    }

    @Transactional
    public boolean deleteByReference(String txtReference) {
        IronshapesTbl existing = ironshapesTblRepo.findByReference(txtReference);
        if (existing != null) {
            ironshapesTblRepo.delete(existing);
            return true;
        }
        return false;
    }




    public byte[] getImage(String reference)
    {

        return ironshapesTblRepo.findByReference(reference).getImgImage();

    }







}

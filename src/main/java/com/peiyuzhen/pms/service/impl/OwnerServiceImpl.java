package com.peiyuzhen.pms.service.impl;

import com.peiyuzhen.pms.domain.Owner;
import com.peiyuzhen.pms.repository.OwnerRepository;
import com.peiyuzhen.pms.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;
    @Override
    public List<Owner> findAllOwnerNotDel() {
        return ownerRepository.findAllOwnerNotDel();
    }

    @Override
    public void delOwnerByOwnerId(String ownerId) {
         ownerRepository.delOwnerByOwnerId(ownerId);
    }

    @Override
    public Owner findOwnerById(String ownerId) {
        return ownerRepository.findOwnerById(ownerId);
    }

    @Override
    public int findOwnerByPhone(String phone) {
        return ownerRepository.findOwnerByPhone(phone);
    }

    @Override
    public void addOwner(Owner owner) {
        owner.setIsDel(0);
        ownerRepository.save(owner);
    }
}

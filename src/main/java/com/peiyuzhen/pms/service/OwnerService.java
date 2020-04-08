package com.peiyuzhen.pms.service;

import com.peiyuzhen.pms.domain.Owner;

import java.util.List;

public interface OwnerService {
    List<Owner> findAllOwnerNotDel();

    void delOwnerByOwnerId(String ownerId);


    Owner findOwnerById(String ownerId);

    int findOwnerByPhone(String phone);

    void addOwner(Owner owner);
}

package com.peiyuzhen.pms.util;

import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class CustomIdGenerator extends IdentityGenerator {
@Autowired
private SnowFlake snowFlake=new SnowFlake(2,3);

    public Serializable generate(SharedSessionContractImplementor session, Object object) throws MappingException {

                   Object id =  snowFlake.nextId();
                if (id != null) {
                        return (Serializable) id;
                       }
                 return super.generate(session, object);
             }

}

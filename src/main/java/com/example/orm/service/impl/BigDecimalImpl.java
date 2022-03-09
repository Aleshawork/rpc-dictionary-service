package com.example.orm.service.impl;

import com.example.orm.JpaRepository;
import com.example.orm.model.BigDecimalModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BigDecimalImpl {
    @Autowired
    JpaRepository jpaRepository;

    public List<BigDecimalModel> getAll(){
        return jpaRepository.executeRequest(
                em->em.createQuery("select b from BigDecimalModel b")
                        .getResultList()
        );
    }
}

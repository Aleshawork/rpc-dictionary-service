package com.example.orm.service.impl;

import com.example.orm.JpaRepository;
import com.example.orm.model.Information;
import com.example.orm.service.utilities.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationServiceImpl implements InformationService {

    @Autowired
    private JpaRepository jpaRepository;

    @Override
    public List<Information> getAllInformation() {
        return jpaRepository.executeRequest(
                em->em.createQuery("select i from Information i",Information.class).getResultList()
        );
    }
}

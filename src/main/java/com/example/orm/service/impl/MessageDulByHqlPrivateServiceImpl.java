package com.example.orm.service.impl;

import com.example.orm.JpaRepository;
import com.example.orm.service.MessageDulByHqlPrivateService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MessageDulByHqlPrivateServiceImpl implements MessageDulByHqlPrivateService {

    private final JpaRepository jpaRepository;


    private String[]  DUL_CODE = {"DulMain","Oooprom"};

    public MessageDulByHqlPrivateServiceImpl(JpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List getMessageDulByHql(String hql) {
        HashMap<String,String[]> map = new HashMap<>();
        map.put("codes",DUL_CODE);


        return  jpaRepository.executeRequestWithFilter(
                em->(em.createQuery(hql)),
                "DUL_FILTER_MAIN",
                map
        ).getResultList();
    }

}

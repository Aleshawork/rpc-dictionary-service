package com.example.orm.service.impl;

import com.example.orm.JpaRepository;
import com.example.orm.service.MessageByHqlService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageByHqlServiceImpl implements MessageByHqlService {

    private  final JpaRepository jpaRepository;

    public MessageByHqlServiceImpl(JpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List getMessageByHql(String hql) {
        List resultList = jpaRepository.executeRequest(
                el -> (el.createQuery(hql))
        ).getResultList();

        return resultList;

    }
}

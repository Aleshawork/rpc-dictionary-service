package com.example.orm.service.impl;

import com.example.orm.JpaRepository;
import com.example.orm.model.User;
import com.example.orm.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService {

    private final JpaRepository jpaRepository;

    public UserServiceImpl(JpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List getUserByHql(String hql) {
        return jpaRepository.executeRequest(
                el->el.createQuery(hql).getResultList()
        );
    }

    @Override
    public User getUserByName(String name) {
        return jpaRepository.getEntityManager().createQuery(
                "select u from User u where u.name=:name ",
                User.class
        ).setParameter("name",name)
                .getResultList().stream()
                .findFirst().get();
    }
}

package com.example.orm.service.impl;

import com.example.orm.JpaRepository;
import com.example.orm.dto.DtoFields;
import com.example.orm.dto.SqlDtoConverter;
import com.example.orm.model.User;
import com.example.orm.service.UserService;
import com.example.orm.service.utilities.SqlQueryHandler;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl  implements UserService {

    private final JpaRepository jpaRepository;
    private SqlDtoConverter sqlDtoConverter = new SqlDtoConverter();
    private static String ENTITY_NAME="User";

    public UserServiceImpl(JpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<DtoFields> getUserByHql(String hql) {
        List<DtoFields> listDto = new ArrayList<>();
        try {
            boolean flag= SqlQueryHandler.checkEntity(hql, ENTITY_NAME);
            if(flag){
                List<String> attrName = SqlQueryHandler.getAttrName(hql);
                List<Tuple> list = jpaRepository.executeRequest(
                        el -> el.createQuery(hql,Tuple.class).setHint("org.hibernate.cacheable", true)
                                .getResultList()
                );
                listDto = list.stream().
                        map(el->SqlDtoConverter.toDto(el,attrName))
                        .collect(Collectors.toList());
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listDto;

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

    @Override
    public User getUserById(Long id) {
        EntityManager entityManager = jpaRepository.getEntityManager();
        Session session = entityManager.unwrap(Session.class);
        User user = session.get(User.class,1L);
        return user;
    }
}

package com.example.orm;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Logger;

@Repository
public class JpaRepository {

     Logger logger =Logger.getLogger(JpaRepository.class.getName());


    private final EntityManagerFactory emf;

    public JpaRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public <R> R  executeRequestWithFilter(Function<Session,R> f, String name, Map<String,String[]> collection){
        Session session = emf.createEntityManager().unwrap(Session.class);
        Filter filter = session.enableFilter(name);
        for(Map.Entry<String,String[]> map:collection.entrySet()){
            logger.info(String.format("Filter: %s, add parameter: {%s,%s} ",name,map.getKey(), Arrays.toString(map.getValue())));
            filter.setParameterList(map.getKey(),map.getValue());
        }
        return f.apply(session);
    }

    public <R> R  executeRequest(Function<Session,R> f){
        Session session = emf.createEntityManager().unwrap(Session.class);
        return f.apply(session);
    }

    public <T> void save(T alement){
        EntityManager entityManager = emf.createEntityManager();
        entityManager.persist(alement);

    }

    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
}

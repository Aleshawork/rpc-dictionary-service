package com.example.orm.testutil;

import com.example.orm.model.Message;
import com.example.orm.model.ObjectType;
import com.example.orm.model.User;
import org.junit.Before;

import java.util.Date;


public abstract  class AbstractMessageBaseTest extends AbstractBaseTest{

    @Before
    public void init(){

        ObjectType objectType = new ObjectType();
        objectType.setCode("DulMain");
        em.persist(objectType);

        User user1 = new User();
        user1.setAge(23);
        user1.setName("Egor");
        user1.setObjectType(objectType);
        em.persist(user1);

        Message message1 = new Message();
        message1.setText("First message");
        message1.setDate(new Date());
        message1.setUser(user1);
        em.persist(message1);
        em.flush();


    }

}

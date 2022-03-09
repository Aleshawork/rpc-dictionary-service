package com.example.orm.controller;

import com.example.orm.model.CardPayment;
import com.example.orm.model.OnlinePayment;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;


public abstract class AbstractPaymentTest extends AbstractBaseControllerTest {

    @Before
    @BeforeEach
    public void initialization(){
        em.createQuery("delete from OnlinePayment online").executeUpdate();
        em.createQuery("delete from CardPayment card").executeUpdate();
        initOnlinePayment();
        initcardPayment();
        em.flush();
        em.clear();
    }

    public void initOnlinePayment(){
        OnlinePayment onlinePayment1 = new OnlinePayment();
        onlinePayment1.setBic("121w");
        onlinePayment1.setFullName("Artem Olegovich");
        onlinePayment1.setAccountNumber("12345");

        OnlinePayment onlinePayment2 = new OnlinePayment();
        onlinePayment2.setBic("33u");
        onlinePayment2.setFullName("Oleg Orlov");
        onlinePayment2.setAccountNumber("45889");

        em.persist(onlinePayment2);
        em.persist(onlinePayment1);
    }
    public void initcardPayment(){
        CardPayment cardPayment1 = new CardPayment();
        cardPayment1.setFullName("Alla Pupkova");
        cardPayment1.setCardNumber("126532346577");
        cardPayment1.setCvc("178");

        CardPayment cardPayment2 = new CardPayment();
        cardPayment2.setFullName("Egor Nosov");
        cardPayment2.setCardNumber("1265345y4574");
        cardPayment2.setCvc("000");

        CardPayment cardPayment3 = new CardPayment();
        cardPayment3.setFullName("Anna Izmesteeva");
        cardPayment3.setCardNumber("7908993");
        cardPayment3.setCvc("111");

        em.persist(cardPayment1);
        em.persist(cardPayment2);
        em.persist(cardPayment3);
    }
}

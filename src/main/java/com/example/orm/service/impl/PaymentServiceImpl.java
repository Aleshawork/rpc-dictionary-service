package com.example.orm.service.impl;

import com.example.orm.JpaRepository;
import com.example.orm.model.BasePaymentRecord;
import com.example.orm.model.CardPayment;
import com.example.orm.model.OnlinePayment;
import com.example.orm.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private JpaRepository jpaRepository;

    @Override
    public <T extends BasePaymentRecord> List<T> getAllPaymentByDate(Date date) {
        List<? extends BasePaymentRecord > listOfPayments = new ArrayList<>();
        List<CardPayment> cardPaymentList = null;
        cardPaymentList = jpaRepository.executeRequest(
                em->(em.createQuery("select l from CardPayment l ",CardPayment.class))
                        //.setParameter("date",date)).
                        .getResultList()
        );
        List<OnlinePayment> onlinePayment = null;
        onlinePayment = jpaRepository.executeRequest(
                r->(r.createQuery("select m from OnlinePayment m ",OnlinePayment.class))
                        //setParameter("date",date).
                        .getResultList()
        );
        if(cardPaymentList!=null) listOfPayments.addAll((List)cardPaymentList);
        if(onlinePayment!=null) listOfPayments.addAll((List)onlinePayment);

        return (List<T>) listOfPayments;
    }
}

package com.example.orm.model;

import javax.persistence.Entity;

@Entity
public class CardPayment extends BasePaymentRecord {

    private String cardNumber;
    private String cvc;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }
}

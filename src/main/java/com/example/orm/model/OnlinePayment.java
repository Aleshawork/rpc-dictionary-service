package com.example.orm.model;

import javax.persistence.Entity;

@Entity
public class OnlinePayment extends BasePaymentRecord {
    private String bic;
    private String accountNumber;

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}

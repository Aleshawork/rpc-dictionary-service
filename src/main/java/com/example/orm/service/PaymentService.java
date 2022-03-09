package com.example.orm.service;

import com.example.orm.model.BasePaymentRecord;

import java.util.Date;
import java.util.List;

public interface PaymentService {
    /**
     * Метод для получения информации о всех платежах за день
     * @param date дата совершения платежа
     * @param <T>
     * @return массив платежей
     */
    public <T extends BasePaymentRecord> List<T> getAllPaymentByDate(Date date);
}

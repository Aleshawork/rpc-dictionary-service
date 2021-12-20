package com.example.orm.dto;


import com.example.orm.model.Message;

import java.util.Date;

public class MessageDto {
    private String text;
    private Date date;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

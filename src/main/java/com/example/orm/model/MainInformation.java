package com.example.orm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainInformation implements Serializable {

    private String code;
    private String source;

    private String date;

    public MainInformation(@JsonProperty(value = "code")String code,
                           @JsonProperty(value = "source")String source,
                           @JsonProperty(value = "date")String date) throws ParseException {

        DateFormat dateFormat =new SimpleDateFormat("yyyy-dd-MM", Locale.ENGLISH);
        this.code = code;
        this.source = source;
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

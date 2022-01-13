package com.example.orm.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseRecords {
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

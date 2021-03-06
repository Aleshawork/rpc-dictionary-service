package com.example.orm.dto;


public class DtoField {
    private String alias;
    private Object value;

    public DtoField(String alias, Object value) {
        this.alias = alias;
        this.value = value;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}

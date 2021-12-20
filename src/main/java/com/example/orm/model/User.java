package com.example.orm.model;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;
@FilterDef(
        name="DUL_FILTER",
        parameters = {@ParamDef(
                name = "codes",
                type="string"
        )}
)
@Filter(name="DUL_FILTER", condition="code in (:codes)")

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    private String code;


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCode() {
        return code;
    }
}

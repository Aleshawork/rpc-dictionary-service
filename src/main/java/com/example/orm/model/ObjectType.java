package com.example.orm.model;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@FilterDef(
        name="DUL_FILTER",
        parameters = {@ParamDef(
                name = "codes",
                type="string"
        )}
)
@Filter(name="DUL_FILTER", condition="code in (:codes)")
@Entity
public class ObjectType extends BaseRecords {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}

package com.example.orm.model;

import com.example.orm.model.converter.MainInformationConverter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "information")
@Entity
public class Information implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    @Convert(converter = MainInformationConverter.class)
    private MainInformation mainInformation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MainInformation getMainInformation() {
        return mainInformation;
    }

    public void setMainInformation(MainInformation mainInformation) {
        this.mainInformation = mainInformation;
    }
}

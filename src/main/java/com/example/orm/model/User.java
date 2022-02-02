package com.example.orm.model;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;


@Entity
@Table(name = "users")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    @OneToMany(mappedBy = "user")
    private List<Message> messages;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="type_id")
    private ObjectType objectType;

    public User() {
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public ObjectType getObjectType() {
        return objectType;
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

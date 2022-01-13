package com.example.orm.model;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterJoinTable;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;
import java.util.List;

@FilterDef(
        name="DUL_FILTER_MAIN",
        parameters = {@ParamDef(
                name = "codes",
                type="string"
        )}
)
@Filter(name="DUL_FILTER_MAIN", condition=
        "type_id  in (select id from object_type o where o.code in (:codes))")
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    @OneToMany(mappedBy = "user")
    private List<Message> messages;

    @ManyToOne()
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

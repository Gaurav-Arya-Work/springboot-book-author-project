package com.gaurav.BookStore.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Document(collection = "author")
public class Author {
    @Id
    @NotNull(message = "You must specify authorId")
    @NotBlank
    private int aid;

    @NotNull(message = "You must specify author name")
    @NotBlank
    private String name;

    @NotNull(message = "You must specify Address")
    @NotBlank
    private Object address;

    public Author(int aid, String name, Object address) {
        this.aid = aid;
        this.name = name;
        this.address = address;
    }
    public Author() {}

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getAddress() {
        return address;
    }

    public void setAddress(Object address) {
        this.address = address;
    }
}

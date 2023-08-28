package com.gaurav.BookStore.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Document(collection = "book")
public class Book {
    @Id
    @NotNull(message = "bid cannot be null")
    @NotBlank
    private int bid;

    @NotNull(message = "you must specify available copies of the book")
    @NotBlank
    private int copiesAvailable;


    @NotNull(message = "You must specify authorId")
    @NotBlank
    private String authorId;


    @NotNull(message = "You must specify genre")
    @NotBlank
    private String genre;

    public Book() {}
    public Book(int bid, int copiesAvailable, String authorId, String genre) {
        super();
        this.bid = bid;
        this.authorId = authorId;
        this.copiesAvailable = copiesAvailable;
        this.genre = genre;
    }
    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}

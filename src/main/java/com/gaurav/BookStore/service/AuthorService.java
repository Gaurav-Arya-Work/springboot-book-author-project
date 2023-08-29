package com.gaurav.BookStore.service;

import com.gaurav.BookStore.model.Author;
import com.gaurav.BookStore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;
    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }

    public List<Author> getSelectedAuthor(String names) {
        return authorRepository.findByNameRegex(names);
    }

    public Author getAuthor(String name){
        return authorRepository.findByName(name);
    }
}

package com.gaurav.BookStore.controller;

import com.gaurav.BookStore.model.Author;
import com.gaurav.BookStore.model.Book;
import com.gaurav.BookStore.service.AuthorService;
import com.gaurav.BookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Author>> getAuthor(){
        return new ResponseEntity<List<Author>>(authorService.getAllAuthor(), HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Author>> getAuthorsByNameRegex(@RequestParam String nameRegex) {
        return new ResponseEntity<List<Author>>(authorService.getSelectedAuthor(nameRegex), HttpStatus.OK);

    }

    @GetMapping("/findBy")
    public Book getAuthor(@RequestParam String name) {
        Author a = authorService.getAuthor(name);
        int id = a.getAid();
        return bookService.getBook(id);
    }

    @PostMapping
    public ResponseEntity<Author> addAuthor(@RequestBody Author author){
        return new ResponseEntity<>(authorService.addAuthor(author), HttpStatus.OK);
    }
}

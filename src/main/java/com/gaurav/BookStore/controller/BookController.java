package com.gaurav.BookStore.controller;

import com.gaurav.BookStore.model.Book;
import com.gaurav.BookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String rootApi(){
        return "Start of the SpringBoot Application";
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity<List<Book>>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/{genre}")
    public ResponseEntity<List<Book>> getBookByGenre(@PathVariable String genre){
        return new ResponseEntity<List<Book>>(bookService.getBooksByGenre(genre), HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Book>> getBooksByGenreAndCopiesAvailable(
            @RequestParam String genre,
            @RequestParam int copiesAvailable) {
        return new ResponseEntity<List<Book>>(bookService.getBookByGenreAndCopies(genre, copiesAvailable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        return new ResponseEntity<>(bookService.addBook(book), HttpStatus.OK);
    }

}

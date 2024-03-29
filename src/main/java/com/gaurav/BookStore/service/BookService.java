package com.gaurav.BookStore.service;

import com.gaurav.BookStore.model.Book;
import com.gaurav.BookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public List<Book> getBooksByGenre(String genre) {
       return bookRepository.findBooksByGenre(genre);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getBookByGenreAndCopies(String genre, int copiesAvailable) {
        return bookRepository.findBooksByGenreAndCopiesAvailable(genre, copiesAvailable);
    }

    public List<Book> getBooks(int id) {
        return bookRepository.findByAuthorId(id);
    }
}

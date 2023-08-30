package com.gaurav.BookStore.service;

import com.gaurav.BookStore.model.Address;
import com.gaurav.BookStore.model.Author;
import com.gaurav.BookStore.model.Book;
import com.gaurav.BookStore.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookServiceTest {

    @MockBean
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @Test
    void getAllBooks() {
        Book book1 = new Book(10, 100, 5, "Fiction");
        Book book2 = new Book(11, 150, 3, "Comic");

        when(bookRepository.findAll()).thenReturn(Stream.of(book1,book2).collect(Collectors.toList()));
        assertEquals(2, bookService.getAllBooks().size());
    }

    @Test
    void getBooksByGenre() {
        Book book1 = new Book(10, 100, 5, "Comic");
        Book book2 = new Book(11, 150, 2, "Comic");
        Book book3 = new Book(12, 160, 1, "Comic");

        String genre = "Comic";
        when(bookRepository.findBooksByGenre(genre)).thenReturn(Stream.of(book1, book2, book3).collect(Collectors.toList()));
        assertEquals(3, bookService.getBooksByGenre(genre).size());
    }

    @Test
    void addBook() {
        Book book = new Book(10, 100, 5, "Fiction");

        when(bookRepository.save(book)).thenReturn(book);
        assertEquals(book, bookService.addBook(book));
    }

    @Test
    void getBookByGenreAndCopies() {
        Book book1 = new Book(10, 100, 5, "Comic");
        Book book2 = new Book(11, 150, 2, "Comic");
        Book book3 = new Book(12, 160, 1, "Comic");
        int copies = 100;
        String genre = "Comic";

        when(bookRepository.findBooksByGenreAndCopiesAvailable(genre, copies)).thenReturn(Stream.of(book2, book3).collect(Collectors.toList()));
        assertEquals(2, bookService.getBookByGenreAndCopies(genre, copies).size());
    }

    @Test
    void getBook() {
        Book book1 = new Book(10, 100, 5, "Fiction");
        Book book2 = new Book(11, 200, 5, "Comic");
        int aid = 5;

        when(bookRepository.findByAuthorId(5)).thenReturn(Stream.of(book1, book2).collect(Collectors.toList()));
        assertEquals(2, bookService.getBooks(aid).size());
    }
}
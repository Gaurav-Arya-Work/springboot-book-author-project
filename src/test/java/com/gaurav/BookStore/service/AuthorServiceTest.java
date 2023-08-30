package com.gaurav.BookStore.service;

import com.gaurav.BookStore.model.Address;
import com.gaurav.BookStore.model.Author;
import com.gaurav.BookStore.repository.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class AuthorServiceTest {

    @Autowired
    private AuthorService authorService;
    @MockBean
    private AuthorRepository authorRepository;

    @Test
    void addAuthor() {
        Address address = new Address("RC13","Noida","Uttar Pradesh");
        Author author = new Author(10,"Gaurav",address);

        when(authorRepository.save(author)).thenReturn(author);
        assertEquals(author,authorService.addAuthor(author));
    }

    @Test
    void getAllAuthor() {
        Address address = new Address("RC13","Noida","Uttar Pradesh");
        Author author = new Author(10,"Gaurav",address);

        when(authorRepository.findAll()).thenReturn(Stream.of(author).collect(Collectors.toList()));
        assertEquals(1, authorService.getAllAuthor().size());
    }

    @Test
    void getSelectedAuthor() {
        Address address = new Address("LN2","Delhi","Delhi");
        Author author = new Author(10,"Raghav",address);
        String name = "Raghav";

        when(authorRepository.findByNameRegex(name)).thenReturn(Stream.of(author).collect(Collectors.toList()));
        assertEquals(1, authorService.getSelectedAuthor(name).size());
    }

    @Test
    void getAuthor() {
        Address address = new Address("LN2","Delhi","Delhi");
        Author author = new Author(10, "Naman", address);
        String name = "Naman";

        when(authorRepository.findByName(name)).thenReturn(author);
        assertEquals(author, authorService.getAuthor(name));
    }
}
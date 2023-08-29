package com.gaurav.BookStore.repository;

import com.gaurav.BookStore.model.Author;
import com.gaurav.BookStore.model.Book;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends MongoRepository<Book, ObjectId> {

    List<Book> findBooksByGenre(String genre);
    //List<Book> getBooksByGenreCopies(String genre, int copies);

    @Query(value = "{'genre': ?0, 'copiesAvailable': {$gt: ?1}}")
    List<Book> findBooksByGenreAndCopiesAvailable(String genre, int copiesAvailable);

    Book findByAuthorId(int id);
}

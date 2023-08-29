package com.gaurav.BookStore.repository;

import com.gaurav.BookStore.model.Book;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book, ObjectId> {

    List<Book> findBooksByGenre(String genre);

    @Query(value = "{'genre': ?0, 'copiesAvailable': {$gt: ?1}}")
    List<Book> findBooksByGenreAndCopiesAvailable(String genre, int copiesAvailable);

    List<Book> findByAuthorId(int id);
}

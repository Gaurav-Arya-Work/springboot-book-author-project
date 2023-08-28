package com.gaurav.BookStore.repository;

import com.gaurav.BookStore.model.Author;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface AuthorRepository extends MongoRepository<Author, ObjectId> {

        @Query("{'name': {$regex: ?0}}")
        List<Author> findByAuthorNameRegex(String nameRegex);
}

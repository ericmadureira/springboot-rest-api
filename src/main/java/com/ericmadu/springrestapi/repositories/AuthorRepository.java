package com.ericmadu.springrestapi.repositories;

import com.ericmadu.springrestapi.domain.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
    Iterable<Author> ageLessThan(int age);

    // HQL query example from JPA.
    @Query("SELECT a FROM Author a WHERE a.age > ?1")
    Iterable<Author> findAuthorsWithAgeGreaterThan(int age);
}

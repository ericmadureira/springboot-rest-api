package com.ericmadu.springrestapi.dao;

import com.ericmadu.springrestapi.domain.Author;

import java.util.Optional;

public interface AuthorDao {
    void create(Author author);

    Optional<Author> findOne(long l);
}

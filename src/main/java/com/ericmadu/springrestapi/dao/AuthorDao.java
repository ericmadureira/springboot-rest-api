package com.ericmadu.springrestapi.dao;

import com.ericmadu.springrestapi.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorDao {
    void create(Author author);

    Optional<Author> findOne(long authorId);

    List<Author> find();

    void update(long id, Author author);
}

package com.ericmadu.springrestapi.dao;

import com.ericmadu.springrestapi.domain.Book;

import java.util.Optional;

public interface BookDao {
    void create(Book book);

    Optional<Book> findOne(String isbn);
}

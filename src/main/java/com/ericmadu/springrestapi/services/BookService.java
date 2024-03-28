package com.ericmadu.springrestapi.services;

import com.ericmadu.springrestapi.domain.entities.BookEntity;

public interface BookService {
    BookEntity createBook(String isbn, BookEntity bookEntity);
}

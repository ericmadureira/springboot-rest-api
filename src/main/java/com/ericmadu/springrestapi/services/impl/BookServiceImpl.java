package com.ericmadu.springrestapi.services.impl;

import com.ericmadu.springrestapi.domain.entities.BookEntity;
import com.ericmadu.springrestapi.repositories.BookRepository;
import com.ericmadu.springrestapi.services.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookEntity createBook(String isbn, BookEntity book) {
        book.setIsbn(isbn);
        return bookRepository.save(book);
    }
}

package com.ericmadu.springrestapi.controllers;

import com.ericmadu.springrestapi.domain.dto.BookDto;
import com.ericmadu.springrestapi.domain.entities.BookEntity;
import com.ericmadu.springrestapi.mappers.impl.BookMapperImpl;
import com.ericmadu.springrestapi.services.impl.BookServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private BookMapperImpl bookMapper;

    private BookServiceImpl bookService;

    public BookController(BookMapperImpl bookMapper, BookServiceImpl bookService) {
        this.bookMapper = bookMapper;
        this.bookService = bookService;
    }

    @PutMapping(path = "/books/{isbn}")
    public ResponseEntity<BookDto> createBook(
            @PathVariable("isbn") String isbn,
            @RequestBody BookDto book
    ) {
        BookEntity bookEntity = bookMapper.mapFrom(book);
        BookEntity savedBookEntity = bookService.createBook(isbn, bookEntity);
        return new ResponseEntity<>(bookMapper.mapTo(savedBookEntity), HttpStatus.CREATED);
    }
}

package com.ericmadu.springrestapi.dao.impl;

import com.ericmadu.springrestapi.dao.BookDao;
import com.ericmadu.springrestapi.domain.Author;
import com.ericmadu.springrestapi.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;

public class BookDaoImpl implements BookDao {
    private final JdbcTemplate jdbcTemplate;

    public BookDaoImpl(final JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Book book) {
        jdbcTemplate.update("INSERT INTO books (isbn, title, authorId) VALUES (?, ?, ?)",
                book.getIsbn(), book.getTitle(), book.getAuthorId()
        );
    }
}

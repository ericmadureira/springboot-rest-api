package com.ericmadu.springrestapi.dao.impl;

import com.ericmadu.springrestapi.dao.impl.BookDaoImpl;
import com.ericmadu.springrestapi.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDaoImplTests {
    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDaoImpl underTests;

    @Test
    public void testThatCreateBookGeneratesCorrectSql() {
        Book book = Book.builder()
                .isbn("123400001234")
                .title("Memoirs of a noob programmer")
                .authorId(1L)
                .build();
        underTests.create(book);

        verify(jdbcTemplate).update(
                eq("INSERT INTO books (isbn, title, authorId) VALUES (?, ?, ?)"),
                eq("123400001234"), eq("Memoirs of a noob programmer"), eq(1L)
        );
    }
}

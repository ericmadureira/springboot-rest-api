package com.ericmadu.springrestapi.dao.impl;

import com.ericmadu.springrestapi.TestDataUtil;
import com.ericmadu.springrestapi.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
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
        Book book = TestDataUtil.createTestBookA();
        underTests.create(book);

        verify(jdbcTemplate).update(
                // Pay ATTENTION to column name format. Must be the same as in schema and DB (author_id !== authorId).
                eq("INSERT INTO books (isbn, title, author_id) VALUES (?, ?, ?)"),
                eq("1111-0000-1111"), eq("Memoirs of a noob programmer"), eq(1L)
        );
    }

    @Test
    public void testThatFindOneGeneratesCorrectSql() {
        underTests.findOne("2222-0000-2222");
        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, author_id FROM books WHERE isbn = ? LIMIT 1"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any(),
                eq("2222-0000-2222")
        );
    }

    @Test
    public void testThatFindGeneratesCorrectSql() {
        underTests.find();
        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, author_id FROM books"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any()
        );
    }

    @Test
    public void testThatUpdateGeneratesCorrectSql() {
        Book book = TestDataUtil.createTestBookA();
        underTests.update(book.getIsbn(), book);
        verify(jdbcTemplate).update("UPDATE books SET isbn = ?, title = ?, author_id = ? WHERE isbn = ?",
                "1111-0000-1111", "Memoirs of a noob programmer", 1L, "1111-0000-1111");
    }

    @Test
    public void testThatDeleteGeneratesCorrectSql() {
        Book book = TestDataUtil.createTestBookA();
        underTests.delete(book.getIsbn());
        verify(jdbcTemplate).update("DELETE FROM books WHERE isbn = ?", book.getIsbn());
    }
}



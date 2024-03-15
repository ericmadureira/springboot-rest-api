package com.ericmadu.springrestapi.dao.impl;

import com.ericmadu.springrestapi.dao.impl.AuthorDaoImpl;
import com.ericmadu.springrestapi.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AuthorDaoImplTests {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private AuthorDaoImpl underTests;

    @Test
    public void testThatCreateAuthorGeneratesCorrectSql() {
        Author author = Author.builder()
                        .id(1L)
                        .name("Eric Madureira")
                        .age(32)
                                .build();
        underTests.create(author);

        verify(jdbcTemplate).update(
                eq("INSERT INTO authors (id, name, age) VALUES (?, ?, ?)"),
                eq(1L), eq("Eric Madureira"), eq(32)
        );
    }

    @Test
    public void testThatFindOneGeneratesCorrectSql() {
        underTests.findOne(1L);
        verify(jdbcTemplate).query(
                eq("SELECT id, name, age FROM authors WHERE id = ? LIMIT 1"),
                ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any(),
                eq(1L)
        );
    }
}

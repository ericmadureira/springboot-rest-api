package com.ericmadu.springrestapi;

import com.ericmadu.springrestapi.domain.Author;
import com.ericmadu.springrestapi.domain.Book;

// Utils classes usually have final modifier.
public final class TestDataUtil {
    private TestDataUtil(){

    }

    public static Author createTestAuthorA() {
        return Author.builder()
                .id(1L)
                .name("Eric Madureira")
                .age(32)
                .build();
    }
    public static Author createTestAuthorB() {
        return Author.builder()
                .id(2L)
                .name("John McClane")
                .age(38)
                .build();
    }
    public static Author createTestAuthorC() {
        return Author.builder()
                .id(3L)
                .name("Hans Gruber")
                .age(42)
                .build();
    }

    public static Book createTestBookA() {
        return Book.builder()
                .isbn("1111-0000-1111")
                .title("Memoirs of a noob programmer")
                .authorId(1L)
                .build();
    }

    public static Book createTestBookB() {
        return Book.builder()
                .isbn("2222-0000-2222")
                .title("Out of Engineering Despair")
                .authorId(2L)
                .build();
    }

    public static Book createTestBookC() {
        return Book.builder()
                .isbn("3333-0000-3333")
                .title("Meaningful days past learning")
                .authorId(3L)
                .build();
    }
}

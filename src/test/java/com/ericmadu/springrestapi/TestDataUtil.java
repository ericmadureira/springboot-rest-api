package com.ericmadu.springrestapi;

import com.ericmadu.springrestapi.domain.AuthorEntity;
import com.ericmadu.springrestapi.domain.BookEntity;

// Utils classes usually have final modifier.
public final class TestDataUtil {
    private TestDataUtil(){

    }

    public static AuthorEntity createTestAuthorA() {
        return AuthorEntity.builder()
                .id(1L)
                .name("Eric Madureira")
                .age(32)
                .build();
    }
    public static AuthorEntity createTestAuthorB() {
        return AuthorEntity.builder()
                .id(2L)
                .name("John McClane")
                .age(38)
                .build();
    }
    public static AuthorEntity createTestAuthorC() {
        return AuthorEntity.builder()
                .id(3L)
                .name("Hans Gruber")
                .age(42)
                .build();
    }

    public static BookEntity createTestBookA(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("1111-0000-1111")
                .title("Memoirs of a noob programmer")
                .author(authorEntity)
                .build();
    }

    public static BookEntity createTestBookB(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("2222-0000-2222")
                .title("Out of Engineering Despair")
                .author(authorEntity)
                .build();
    }

    public static BookEntity createTestBookC(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("3333-0000-3333")
                .title("Meaningful days past learning")
                .author(authorEntity)
                .build();
    }
}

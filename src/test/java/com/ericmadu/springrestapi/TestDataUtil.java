package com.ericmadu.springrestapi;

import com.ericmadu.springrestapi.domain.Author;

// Utils classes usually have final modifier.
public final class TestDataUtil {
    private TestDataUtil(){

    }

    public static Author createTestAuthor() {
        return Author.builder()
                .id(1L)
                .name("Eric Madureira")
                .age(32)
                .build();
    }
}

package com.ericmadu.springrestapi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {

    // Long defaults to null, while long defaults to 0.
    private Long id;
    private String name;
    private Integer age;

}

package com.ericmadu.springrestapi.controllers;

import com.ericmadu.springrestapi.domain.dto.AuthorDto;
import com.ericmadu.springrestapi.services.AuthorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping(path = "/authors")
    public AuthorDto createAuthor(@RequestBody AuthorDto author) {
        authorService.createAuthor(author);
    }
}

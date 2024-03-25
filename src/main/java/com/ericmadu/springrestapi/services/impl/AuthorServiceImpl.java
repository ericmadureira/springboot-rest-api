package com.ericmadu.springrestapi.services.impl;

import com.ericmadu.springrestapi.domain.entities.AuthorEntity;
import com.ericmadu.springrestapi.repositories.AuthorRepository;
import com.ericmadu.springrestapi.services.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorEntity createAuthor(AuthorEntity authorEntity) {
        return authorRepository.save(authorEntity);
    }
}

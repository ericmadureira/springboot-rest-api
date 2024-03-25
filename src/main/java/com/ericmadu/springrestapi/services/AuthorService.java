package com.ericmadu.springrestapi.services;

import com.ericmadu.springrestapi.domain.entities.AuthorEntity;

public interface AuthorService {
    AuthorEntity createAuthor(AuthorEntity authorEntity);
}

package com.ericmadu.springrestapi.repositories;

import com.ericmadu.springrestapi.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}

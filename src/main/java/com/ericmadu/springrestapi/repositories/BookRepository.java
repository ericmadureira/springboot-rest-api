package com.ericmadu.springrestapi.repositories;

import com.ericmadu.springrestapi.domain.BookEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<BookEntity, String> {
}

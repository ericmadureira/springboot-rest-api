package com.ericmadu.springrestapi.repositories;

import com.ericmadu.springrestapi.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, String> {
}

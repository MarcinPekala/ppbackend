package com.app.ppbackend.repository;

import com.app.ppbackend.domain.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {
    @Override
    List<Book> findAll();

    @Override
    Book save(Book book);

    Optional<Book> findById(Long id);

    List<Book> getBookByAuthor(String author);

    @Override
    void deleteById(Long id);

    @Override
    long count();
}
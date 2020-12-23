package com.app.ppbackend.service;

import com.app.ppbackend.domain.Book;
import com.app.ppbackend.domain.BookDto;
import com.app.ppbackend.exceptions.BookNotFoundException;
import com.app.ppbackend.repository.BookRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Book createBook(final Book book) {
        Optional<Book> bookOptional = repository.findById(book.getId());
        if (!bookOptional.isPresent()) {
            return repository.save(book);
        }
        return book;
    }

    public Book updateBook(Book book) {
        Optional<Book> bookOptional = repository.findById(book.getId());
        if (bookOptional.isPresent()) {
            return repository.save(book);
        }
        return book;
    }

    public Book getBook(final Long bookId) throws BookNotFoundException {
        return repository.findById(bookId).orElseThrow(BookNotFoundException::new);
    }

    public List<Book> getBookByAuthor(String author) {
        return repository.getBookByAuthor(author);
    }

    public void deleteBookByID(long bookID) throws BookNotFoundException {
        Book deleteBook = repository.findById(bookID).orElseThrow(BookNotFoundException::new);
        repository.delete(deleteBook);
    }

    public void deleteAllBooks() {
        repository.deleteAll();
    }

    public long countAllBooks() {
        return repository.count();
    }
}

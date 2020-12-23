package com.app.ppbackend.controller;

import com.app.ppbackend.domain.Book;
import com.app.ppbackend.domain.BookDto;
import com.app.ppbackend.exceptions.BookNotFoundException;
import com.app.ppbackend.facade.BookFacade;
import com.app.ppbackend.mapper.BookMapper;
import com.app.ppbackend.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookFacade bookFacade;

    private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    @RequestMapping(method = RequestMethod.GET, value = "/getBooks")
    public List<BookDto> getBooks() {
        LOGGER.info("Started method getBooks in BookController.");
        LOGGER.info("Ended method getBook in BookController.");

        return bookMapper.mapToBookDtoList(bookService.getAllBooks());
    }

    @RequestMapping(method =  RequestMethod.GET, value = "/getBooksForJUnitTests")
    public List<Book> getBooksForJUnitTests() {
        LOGGER.info("Started method getBooks in BookController.");
        LOGGER.info("Ended method getBooks in BookController.");

        return bookFacade.getAllBooksFacade();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getBook")
    public BookDto getBook(@RequestParam Long bookId) throws BookNotFoundException {
        LOGGER.info("Started method getBook in BookController.");
        return bookMapper.mapToBookDto(bookService.getBook(bookId));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getAuthor")
    public List<BookDto> getBookByAuthor(@RequestParam String bookAuthor) {
        LOGGER.info("Started method getBookByAuthor in BookController.");

        return bookMapper.mapToBookDtoList(bookService.getBookByAuthor(bookAuthor));
    }

    @DeleteMapping(value = "/deleteBook")
    public void deleteBook(@RequestParam Long bookId) throws BookNotFoundException {
        LOGGER.info("Started method deleteBook in BookController.");

        bookService.deleteBookByID(bookId);

        LOGGER.info("Ended method deleteBook in BookController.");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteAllBooks")
    public void deleteAllBooks() {
        LOGGER.info("Started method deleteAllBooks in BookController.");

        bookService.deleteAllBooks();

        LOGGER.info("Ended method deleteAllBooks in BookController.");
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateBook")
    public BookDto updateBook(@RequestBody BookDto bookDto) {
        LOGGER.info("Started method updateBook in BookController.");
        LOGGER.info("Ended method deleteBook in BookController.");

        return bookMapper.mapToBookDto(bookService.updateBook(bookMapper.mapToBook(bookDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createBook", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createBook(@RequestBody BookDto bookDto) {
        LOGGER.info("Started method createBook in BookController.");

        bookService.createBook(bookMapper.mapToBook(bookDto));

        LOGGER.info("Started method createBook in BookController.");
    }

   @GetMapping(value = "/countAllBooks")
   public Long countAllBooks() {
        LOGGER.info("Started method countAllBooks in BookController.");
        long allBooks = bookService.countAllBooks();

        LOGGER.info("Ended method countAllBooks in BookController.");
        return allBooks;
    }
}

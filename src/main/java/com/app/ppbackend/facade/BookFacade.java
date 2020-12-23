package com.app.ppbackend.facade;

import com.app.ppbackend.domain.Book;
import com.app.ppbackend.domain.BookDto;
import com.app.ppbackend.mapper.BookMapper;
import com.app.ppbackend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class BookFacade {
    @Autowired
  private BookService bookService;

    @Autowired
  private BookMapper bookMapper;

    public List<Book> getAllBooksFacade() {
        List<BookDto> bookDtoList = bookMapper.mapToBookDtoList(bookService.getAllBooks());
        return bookMapper.mapToBookList(bookDtoList);
    }
}

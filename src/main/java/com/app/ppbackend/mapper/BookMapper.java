package com.app.ppbackend.mapper;

import com.app.ppbackend.domain.Book;
import com.app.ppbackend.domain.BookDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {
    public Book mapToBook(final BookDto bookDto) {
        return new Book(
                bookDto.getId(),
                bookDto.getAuthor(),
                bookDto.getTitle(),
                bookDto.getYearOfPublication());
    }

    public BookDto mapToBookDto(final Book book) {
        return new BookDto(
                book.getId(),
                book.getAuthor(),
                book.getTitle(),
                book.getYearOfPublication());
    }

    public List<BookDto> mapToBookDtoList(final List<Book> bookList) {
        return bookList.stream()
                .map(t -> new BookDto(t.getId(), t.getAuthor(), t.getTitle(), t.getYearOfPublication()))
                .collect(Collectors.toList());
    }

    public List<Book> mapToBookList(final List<BookDto> bookDtoList) {
        return bookDtoList.stream()
                .map(t -> new Book(t.getId(), t.getAuthor(), t.getTitle(), t.getYearOfPublication()))
                .collect(Collectors.toList());
    }
}


package com.app.ppbackend.facade;

import com.app.ppbackend.domain.Book;
import com.app.ppbackend.domain.BookDto;
import com.app.ppbackend.factory.BookDtoFactory;
import com.app.ppbackend.factory.BookFactory;
import com.app.ppbackend.mapper.BookMapper;
import com.app.ppbackend.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class BookFacadeTestSuite {
    @InjectMocks
    private BookFacade bookFacade;

    @Mock
    private BookService bookService;

    @Mock
    private BookMapper bookMapper;

    BookFactory factory = new BookFactory();
    BookDtoFactory factoryDto = new BookDtoFactory();

    @Test
    public void getAllBooksFacadeTest() {
        //Given
        List<BookDto> bookDtoList = new ArrayList<>();
        bookDtoList.add(factoryDto.processBook(BookDtoFactory.BOOKDTOTYPE1));

        List<Book> bookList = new ArrayList<>();
        bookList.add(factory.processBook(BookFactory.BOOKTYPE1));


        when(bookService.getAllBooks()).thenReturn(bookList);
        when(bookMapper.mapToBookDtoList(bookList)).thenReturn(bookDtoList);
        when(bookMapper.mapToBookList(bookDtoList)).thenReturn(bookList);

        //When
        List<Book> bookListFacade = bookFacade.getAllBooksFacade();

        //Then
        assertNotNull(bookListFacade);
        assertEquals(1, bookListFacade.size());

        bookListFacade.forEach(book -> {
            assertEquals(1L, bookList.size());
        });
    }
}

package com.app.ppbackend.mapper;

import com.app.ppbackend.domain.Book;
import com.app.ppbackend.domain.BookDto;
import com.app.ppbackend.factory.BookDtoFactory;
import com.app.ppbackend.factory.BookFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookMapperTestSuite {

    @Autowired
    private BookMapper bookMapper;

    BookDtoFactory factoryDto = new BookDtoFactory();

    BookFactory factory = new BookFactory();

    @Test
    public void testMapToBookTest() {
        //Given
        BookDto bookDto = new BookDto(1L, "testBookAuthor", "testBookTitle", 2020);

        //When
        Book book = bookMapper.mapToBook(bookDto);

        //Then
        assertEquals("testBookTitle", book.getTitle());
    }

    @Test
    public void testMapToBookDtoTest() {
        //Given
        Book book = factory.processBook(BookFactory.BOOKTYPE1);


        //When
        BookDto bookDto = bookMapper.mapToBookDto(book);

        //Then
        assertEquals("testBookTitle", bookDto.getTitle());
    }

    @Test
    public void testMapToBookDtoListTest() {
        //Given
        Book book = factory.processBook(BookFactory.BOOKTYPE1);
        Book book2 = factory.processBook(BookFactory.BOOKTYPE2);

        List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        bookList.add(book2);

        //When
        List<BookDto> bookDtoList = bookMapper.mapToBookDtoList(bookList);

        //Then
        assertEquals(2, bookDtoList.size());
    }

    @Test
    public void testMapToBookListTest() {
        //Given
        BookDto bookDto = factoryDto.processBook(BookDtoFactory.BOOKDTOTYPE1);
        BookDto bookDto2 = factoryDto.processBook(BookDtoFactory.BOOKDTOTYPE2);

        List<BookDto> bookDtoList = new ArrayList<>();
        bookDtoList.add(bookDto);
        bookDtoList.add(bookDto2);

        //When
        List<Book> bookList = bookMapper.mapToBookList(bookDtoList);

        //Then
        assertEquals(2, bookList.size());
    }
}

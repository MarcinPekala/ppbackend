package com.app.ppbackend.service;

import com.app.ppbackend.domain.Book;
import com.app.ppbackend.exceptions.BookNotFoundException;
import com.app.ppbackend.factory.BookFactory;
import com.app.ppbackend.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.Silent.class)
public class BookServiceTestSuite {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    BookFactory factory = new BookFactory();

    @Test
    public void createBookTest() {
        //Given
        Book bookTest = factory.processBook(BookFactory.BOOKTYPE1);


        //When
        when(bookRepository.save(bookTest)).thenReturn((bookTest));
        bookService.createBook(bookTest);

        //Then
        verify(bookRepository, times(1)).save(bookTest);
    }

    @Test
    public void getAllBookTest() {
        //Given
        List<Book> bookListTest = new ArrayList<>();
        bookListTest.add(factory.processBook(BookFactory.BOOKTYPE1));
        bookListTest.add(factory.processBook(BookFactory.BOOKTYPE2));

        //When
        when(bookService.getAllBooks()).thenReturn(bookListTest);

        //Then
        assertEquals(2, bookListTest.size());
    }

    @Test
    public void findBookByAuthorTest() {
        //Given
        List<Book> bookListTest = new ArrayList<>();
        Book bookTest = factory.processBook(BookFactory.BOOKTYPE1);
        bookListTest.add(bookTest);

        String bookTestAuthor = bookTest.getAuthor();
        String bookTestTitle = bookTest.getTitle();

        //When
        when(bookRepository.getBookByAuthor(bookTestAuthor)).thenReturn(bookListTest);

        //Then
        assertEquals("testBookTitle", bookTestTitle);
        assertEquals("testBookAuthor", bookTestAuthor);
    }

    @Test
    public void findBookByIdTest() {
        //Given
        Book bookTest = factory.processBook(BookFactory.BOOKTYPE1);
        Long bookTestID = bookTest.getId();
        Optional<Book> optionalBookTest = Optional.of(bookTest);

        String bookTestText = bookTest.getTitle();

        //When
        when(bookRepository.findById(bookTestID)).thenReturn(optionalBookTest);

        //Then
        assertEquals("testBookTitle", bookTestText);
    }

    @Test
    public void deleteBookByIdTest() throws BookNotFoundException {
        //Given
        Book bookTest = factory.processBook(BookFactory.BOOKTYPE1);


        Long bookTestId = bookTest.getId();

        //When
        when(bookRepository.findById(bookTestId)).thenReturn(Optional.of(bookTest));

        doNothing().when(bookRepository).delete(bookTest);
        bookService.deleteBookByID(bookTestId);

        //Then
        verify(bookRepository, times(1)).delete(bookTest);
    }

    @Test
    public void deleteAllBooks() throws BookNotFoundException {
        //Given
        Book bookTest = factory.processBook(BookFactory.BOOKTYPE1);
        bookRepository.save(bookTest);

        //When
        doNothing().when(bookRepository).deleteAll();
        bookService.deleteAllBooks();

        //Then
        verify(bookRepository, times(1)).deleteAll();
    }

    @Test
    public void countAllBooksTest() {
        //Given
        Book bookTest = factory.processBook(BookFactory.BOOKTYPE1);
        bookRepository.save(bookTest);
        long countAllBooks = bookRepository.count();

        //When
        when(bookService.countAllBooks()).thenReturn(countAllBooks);

        //Then
        verify(bookRepository, times(1)).count();
    }
}

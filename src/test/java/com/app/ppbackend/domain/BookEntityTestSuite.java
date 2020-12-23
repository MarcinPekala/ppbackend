package com.app.ppbackend.domain;

import com.app.ppbackend.exceptions.BookNotFoundException;
import com.app.ppbackend.factory.BookFactory;
import com.app.ppbackend.repository.BookRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class BookEntityTestSuite {

    @Autowired
    private BookRepository bookRepository;

    BookFactory factory = new BookFactory();

    @Test
    public void bookSaveTest() {
        //Given
       // Book bookTest = factory.processBook(BookFactory.BOOKTYPE1);
         Book bookTest = new Book(1L, "ExampleAuthor", "ExampleTitle", 2020);

        //When
        bookRepository.deleteAll();
        Book savedBookTest = bookRepository.save(bookTest);
        long bookTestId = savedBookTest.getId();

        //Then
        Assert.assertNotEquals(0, bookTestId);
        Assert.assertEquals(1L, bookTestId);

        //CleanUp
        bookRepository.deleteById(bookTestId);
        bookRepository.deleteAll();
    }

    @Test
    public void bookReadTest() throws BookNotFoundException {
        //Given
        Book bookTest = factory.processBook(BookFactory.BOOKTYPE1);

        //When
        Book savedBook = bookRepository.save(bookTest);
        long bookTestId = savedBook.getId();

        //Then
        Book resultReadTest = bookRepository.findById(bookTestId).orElseThrow(BookNotFoundException::new);

        Assert.assertEquals("testBookAuthor", resultReadTest.getAuthor());
        Assert.assertEquals("testBookTitle", resultReadTest.getTitle());

        //CleanUp
        bookRepository.deleteById(bookTestId);
        bookRepository.deleteAll();
    }

    @Test
    public void bookUpdateTest() throws BookNotFoundException {
        //Given
        Book bookTest = factory.processBook(BookFactory.BOOKTYPE1);

        //When
        bookRepository.save(bookTest);
        long bookTestId = bookTest.getId();

        //Then
        Book updatedBookTest = bookRepository.findById(bookTestId).orElseThrow(BookNotFoundException::new);
        updatedBookTest.setTitle("testBookTitleUpdated");
        bookRepository.save(updatedBookTest);

        Book resultUpdateTest = bookRepository.findById(bookTestId).orElseThrow(BookNotFoundException::new);

        //Then
        Assert.assertEquals("testBookTitleUpdated", resultUpdateTest.getTitle());

        //CleanUp
        bookRepository.deleteById(bookTestId);
        bookRepository.deleteAll();
    }

    @Test
    public void bookDeleteTest() throws BookNotFoundException {
        //Given
        Book bookTest = factory.processBook(BookFactory.BOOKTYPE1);

        //When
        Book savedBook = bookRepository.save(bookTest);
        long bookTestId = savedBook.getId();
        long countBeforeDelete = bookRepository.count();

        //Then
        bookRepository.deleteById(bookTestId);
        long countAfterDelete = bookRepository.count();

        Assert.assertEquals(countBeforeDelete - 1, countAfterDelete);

        //Clean up
        bookRepository.deleteAll();
    }

    @Test
    public void deleteAllBooksTest() {
        //Given
       bookRepository.deleteAll();
       Book bookTest = factory.processBook(BookFactory.BOOKTYPE1);
        Book bookTest2 = factory.processBook(BookFactory.BOOKTYPE2);

        //When
        bookRepository.save(bookTest);
        bookRepository.save(bookTest2);

        long countBeforeDelete = bookRepository.count();

        //Then
        bookRepository.deleteAll();
        long countAfterDelete = bookRepository.count();

        Assert.assertEquals(countBeforeDelete - 2, countAfterDelete);

        //Clean up
        bookRepository.deleteAll();
    }

    @Test
    public void countAllBooksTest() {
        //Given
        bookRepository.deleteAll();
        Book bookTest = factory.processBook(BookFactory.BOOKTYPE1);
        Book bookTest2 = factory.processBook(BookFactory.BOOKTYPE2);

        //When
        bookRepository.save(bookTest);
        long countBookCountTest = bookRepository.count();

        bookRepository.save(bookTest2);
        long countBookCountTest2 = bookRepository.count();

        //Then
        Assert.assertEquals(1, countBookCountTest);
        Assert.assertEquals(2, countBookCountTest2);

        //Clean up
        bookRepository.deleteAll();
    }
}

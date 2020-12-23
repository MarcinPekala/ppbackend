package com.app.ppbackend.controller;

import com.app.ppbackend.domain.Book;
import com.app.ppbackend.domain.BookDto;
import com.app.ppbackend.facade.BookFacade;
import com.app.ppbackend.factory.BookDtoFactory;
import com.app.ppbackend.factory.BookFactory;
import com.app.ppbackend.mapper.BookMapper;
import com.app.ppbackend.service.BookService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.internal.progress.ArgumentMatcherStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Matchers.notNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTestSuite {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @MockBean
    private BookMapper bookMapper;

    @MockBean
    private BookFacade bookFacade;

    BookFactory factory = new BookFactory();

    BookDtoFactory factoryDto = new BookDtoFactory();

    @Test
    public void getEmptyBooksTest() throws Exception {
    //Given
        List<Book> bookListTest = new ArrayList<>();

        when(bookService.getAllBooks()).thenReturn(bookListTest);

    //When & Then
        mockMvc.perform(get("/v1/getBooksForJUnitTests").contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$", hasSize(0)))
                .andExpect(status().isOk());
    }

    @Test
    public void getBooksTest() throws Exception {
        //Given
        List<Book> bookListTest = new ArrayList<>();
        bookListTest.add(new Book(1L, "testBookAuthor", "testBookTitle", 2010));

        List<BookDto> bookDtoListTest = new ArrayList<>();
        bookDtoListTest.add(new BookDto(1L, "testBookDtoAuthor", "testBookDtoTitle", 2010));

        when(bookService.getAllBooks()).thenReturn(bookListTest);
        when(bookMapper.mapToBookDtoList(bookListTest)).thenReturn(bookDtoListTest);

        //When & Then
        mockMvc.perform(get("/v1/getBooks").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].author", is("testBookDtoAuthor")))
                .andExpect(jsonPath("$[0].title", is("testBookDtoTitle")))
                .andExpect(jsonPath("$[0].yearOfPublication", is(2010)));
    }

    @Test
    public void getBookTest() throws Exception {
        //Given
        Book bookTest = new Book(1L, "testBookAuthor", "testBookTitle", 2010);
        long bookIdTest = bookTest.getId();

        BookDto bookDtoTest = new BookDto(1L, "testBookDtoAuthor", "testBookDtoTitle", 2010);

        when(bookService.getBook(bookIdTest)).thenReturn(bookTest);
        when(bookMapper.mapToBookDto(bookTest)).thenReturn(bookDtoTest);

        //When & Then
        mockMvc.perform(get("/v1/getBook").contentType(MediaType.APPLICATION_JSON)
        .param("bookId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.author", is("testBookDtoAuthor")))
                .andExpect(jsonPath("$.title", is("testBookDtoTitle")))
                .andExpect(jsonPath("$.yearOfPublication", is(2010)));
    }

    @Test
    public void getBookByAuthorTest() throws Exception {
    //Given
        Book bookTest = factory.processBook(BookFactory.BOOKTYPE1);
        String bookAuthorTest = bookTest.getAuthor();

        List<Book> bookListTest = new ArrayList<>();
        bookListTest.add(bookTest);

        BookDto bookDtoTest = new BookDto(1L, "testBookDtoAuthor", "testBookDtoTitle", 2020);
        List<BookDto> bookDtoListTest = new ArrayList<>();
        bookDtoListTest.add(bookDtoTest);

        when(bookService.getBookByAuthor(bookAuthorTest)).thenReturn(bookListTest);
        when(bookMapper.mapToBookDtoList(bookListTest)).thenReturn(bookDtoListTest);

        //When & Then
        mockMvc.perform(get("/v1/getAuthor").contentType(MediaType.APPLICATION_JSON)
        .param("bookAuthor", "testBookAuthor"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].author", is("testBookDtoAuthor")))
                .andExpect(jsonPath("$[0].title", is("testBookDtoTitle")))
                .andExpect(jsonPath("$[0].yearOfPublication", is(2020)));
    }

    @Test
    public void deleteBookTest() throws Exception {
        //Given
        Book bookTest = factory.processBook(BookFactory.BOOKTYPE1);
        long bookIDTest = bookTest.getId();

        when(bookService.getBook(bookIDTest)).thenReturn(bookTest);

        //When & Then
        mockMvc.perform(delete("/v1/deleteBook").contentType(MediaType.APPLICATION_JSON)
        .param("bookId", "1"))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteAllBooksTest() throws Exception {
        //Given
        doNothing().when(bookService).deleteAllBooks();

        //When & Then
        mockMvc.perform(delete("/v1/deleteAllBooks").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void updateBookTest() throws Exception {
        //Given
        Book bookTestUpdate = new Book(1L, "bookAuthorUpdate", "bookTitleUpdate", 2020);
        BookDto bookDtoTestUpdate = new BookDto(1L, "bookAuthorDtoUpdate", "bookTitleDtoUpdate", 2020);

        when(bookMapper.mapToBook(ArgumentMatchers.any(BookDto.class))).thenReturn(bookTestUpdate);
        when(bookService.updateBook(bookTestUpdate)).thenReturn(bookTestUpdate);
        when(bookMapper.mapToBookDto(bookTestUpdate)).thenReturn(bookDtoTestUpdate);

        Gson gson = new GsonBuilder()
                .create();

        String jsonContent = gson.toJson(bookDtoTestUpdate);

        System.out.println("value of jsonContent >> " + jsonContent);

        //When & Then
        mockMvc.perform(put("/v1/updateBook")
        .contentType(MediaType.APPLICATION_JSON)
        .characterEncoding("UTF-8")
        .content(jsonContent))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.author", is("bookAuthorDtoUpdate")))
                .andExpect(jsonPath("$.title", is("bookTitleDtoUpdate")))
                .andExpect(jsonPath("$.yearOfPublication", is(2020)));
    }

    @Test
    public void createBookTest() throws Exception {
        //Given
        Book bookTest = factory.processBook(BookFactory.BOOKTYPE1);
        BookDto bookDtoTest = factoryDto.processBook(BookDtoFactory.BOOKDTOTYPE1);

        Gson gson = new GsonBuilder()
                .create();

        when(bookMapper.mapToBook(bookDtoTest)).thenReturn(bookTest);
        when(bookService.createBook(bookTest)).thenReturn(bookTest);

        String jsonContent = gson.toJson(bookDtoTest);
        //When & Then
        mockMvc.perform(post("/v1/createBook")
        .contentType(MediaType.APPLICATION_JSON)
        .characterEncoding("UTF-8")
        .content(jsonContent))
        .andExpect(status().isOk());

    }

    @Test
    public void countAllBooksTest() throws Exception {
        //Given

        Book bookTest = factory.processBook(BookFactory.BOOKTYPE1);

        Book bookTest2 = factory.processBook(BookFactory.BOOKTYPE2);

        BookDto bookDtoTest = factoryDto.processBook(BookDtoFactory.BOOKDTOTYPE1);
        BookDto bookDtoTest2 = factoryDto.processBook(BookDtoFactory.BOOKDTOTYPE2);

        long currentBooksSize = 2;

        when(bookService.createBook(bookTest)).thenReturn(bookTest);
        when(bookService.createBook(bookTest2)).thenReturn(bookTest2);
        when(bookMapper.mapToBookDto(bookTest)).thenReturn(bookDtoTest);
        when(bookMapper.mapToBookDto(bookTest2)).thenReturn(bookDtoTest2);
        when(bookService.countAllBooks()).thenReturn(currentBooksSize);

        //When & Then
        mockMvc.perform(get("/v1/countAllBooks").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(2)));
    }
}

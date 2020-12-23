package com.app.ppbackend.factory;

import com.app.ppbackend.domain.Book;

public class BookFactory {
    public static final String BOOKTYPE1 = "BOOK1";
    public static final String BOOKTYPE2 = "BOOK2";

    public final Book processBook(final String bookClass) {
        switch (bookClass) {
            case BOOKTYPE1:
                return new Book(1L, "testBookAuthor", "testBookTitle", 2020);
            case BOOKTYPE2:
                return new Book(2L, "testBookAuthor2", "testBookTitle2", 2020);
            default:
                return null;
        }
    }
}

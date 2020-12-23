package com.app.ppbackend.factory;

import com.app.ppbackend.domain.Book;
import com.app.ppbackend.domain.BookDto;

public class BookDtoFactory {
    public static final String BOOKDTOTYPE1 = "BOOKDTO1";
    public static final String BOOKDTOTYPE2 = "BOOKDTO2";

    public final BookDto processBook(final String bookClass) {
        switch (bookClass) {
            case BOOKDTOTYPE1:
                return new BookDto(1L, "testBookDtoAuthor", "testBookDtoTitle", 2020);
            case BOOKDTOTYPE2:
                return new BookDto(2L, "testBookDtoAuthor2", "testBookDtoTitle2", 2020);
            default:
                return null;
        }
    }
}

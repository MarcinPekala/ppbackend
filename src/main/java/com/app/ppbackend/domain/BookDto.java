package com.app.ppbackend.domain;

public class BookDto {
    private Long id;
    private String author;
    private String title;
    private Integer yearOfPublication;

    public BookDto(Long id, String author, String title, Integer yearOfPublication) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.yearOfPublication = yearOfPublication;
    }

    public BookDto() {
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYearOfPublication() {
        return yearOfPublication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookDto)) return false;

        BookDto bookDto = (BookDto) o;

        if (getId() != null ? !getId().equals(bookDto.getId()) : bookDto.getId() != null) return false;
        if (getAuthor() != null ? !getAuthor().equals(bookDto.getAuthor()) : bookDto.getAuthor() != null) return false;
        if (getTitle() != null ? !getTitle().equals(bookDto.getTitle()) : bookDto.getTitle() != null) return false;
        return getYearOfPublication() != null ? getYearOfPublication().equals(bookDto.getYearOfPublication()) : bookDto.getYearOfPublication() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getAuthor() != null ? getAuthor().hashCode() : 0);
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getYearOfPublication() != null ? getYearOfPublication().hashCode() : 0);
        return result;
    }
}

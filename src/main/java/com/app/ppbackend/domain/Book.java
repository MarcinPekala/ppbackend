package com.app.ppbackend.domain;

import com.sun.istack.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "BOOK")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Nullable
    @Column(name = "author")
    private String author;

    @Nullable
    @Column(name = "title")
    private String title;

    @Nullable
    @Column(name = "yearOfPublication")
    private Integer yearOfPublication;

    public Book(Long id, String author, String title, Integer yearOfPublication) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.yearOfPublication = yearOfPublication;
    }

    public Book() {
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYearOfPublication(Integer yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                '}';
    }
}
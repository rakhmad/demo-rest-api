package id.rakhmad.demo.rest;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class Book {

    public String title;
    public String author;
    public String isbn_code;
    public String publisher;

    public Book() {

    }

    public Book(String title, String author, String isbn_code, String publisher) {
        this.title = title;
        this.author = author;
        this.isbn_code = isbn_code;
        this.publisher = publisher;
    }
}

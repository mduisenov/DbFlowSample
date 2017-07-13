package com.demo.dbflowsample.mock_helper;

import com.demo.dbflowsample.db.Author;
import com.demo.dbflowsample.db.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * author marat
 * since 13.07.2017.
 */

public class MockHelper {

    public static List<Book> getBooks(){
        List<Book> books = new ArrayList<>();
        // Alice
        Book alice = new Book();
        alice.setId(1);
        alice.setPages(200);
        alice.setTitle("Alice in wonderland");
        alice.setAuthors(getAuthors());

        // Goethe faust
        Book faust = getFaust();
        books.add(alice);
        books.add(faust);
        return books;
    }


    public static Book getAlice(){
        Book book = new Book();
        book.setId(1);
        book.setPages(200);
        book.setTitle("Alice in wonderland");
        book.setAuthors(getAuthors());
        return book;
    }

    public static Book getFaust(){
        Book book = new Book();
        book.setId(1);
        book.setPages(327);
        book.setTitle("Faust");
        book.setAuthors(getAuthors());
        return book;
    }

    private static List<Author> getAuthors() {
        List<Author> authors = new ArrayList<>();
        Author author = new Author();
        author.setId(24);
        author.setName("Lewis Carroll");
        authors.add(author);
        return authors;
    }
}

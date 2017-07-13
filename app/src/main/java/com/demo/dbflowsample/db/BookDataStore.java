package com.demo.dbflowsample.db;

import java.util.List;

/**
 * author marat
 * since 13.07.2017.
 */

public interface BookDataStore {
    List<Book> loadBooks();

    void saveBookList(List<Book> bookList);

    Book loadBook(int bookId);

    void saveBook(Book book);

    void clean();
}

package com.demo.dbflowsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.demo.dbflowsample.db.Book;
import com.demo.dbflowsample.db.BookLocalStore;
import com.demo.dbflowsample.mock_helper.MockHelper;

import java.util.List;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    private final BookLocalStore bookLocalStore;

    public MainActivity() {
        bookLocalStore = new BookLocalStore();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Book book = MockHelper.getAlice();
        Timber.d("saveBooks() until save %s", "" + book);
        bookLocalStore.saveBook(book);

        Book bookFromDb = bookLocalStore.loadBook(1);
        Timber.d("loadBookFromDb() %s", "" + bookFromDb);

        List<Book> books = MockHelper.getBooks();

        Timber.d("saveBooks() until save %s", "" + books);
        bookLocalStore.saveBookList(books);

        List<Book> booksDb = bookLocalStore.loadBooks();
        Timber.d("loadBooksFromDb() %s", "" + booksDb);

    }
}

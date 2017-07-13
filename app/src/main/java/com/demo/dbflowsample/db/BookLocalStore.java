package com.demo.dbflowsample.db;

import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.Delete;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.database.transaction.FastStoreModelTransaction;

import java.util.List;

import timber.log.Timber;

/**
 * author marat
 * since 13.07.2017.
 */

public class BookLocalStore implements BookDataStore{

    @Override
    public List<Book> loadBooks() {
        List<Book> bookList = SQLite.select().from(Book.class).queryList();
        Timber.d("loadBooks() from db %s ", bookList);
        return bookList;
    }

    @Override
    public void saveBookList(List<Book> bookList) {
        FastStoreModelTransaction<Book> transaction = FastStoreModelTransaction
                .insertBuilder(FlowManager.getModelAdapter(Book.class))
                .addAll(bookList)
                .build();
        for (Book book :
                bookList) {
            book.save();
        }
        DatabaseDefinition database = FlowManager.getDatabase(AppDatabase.class);
        database.executeTransaction(transaction);
    }

    @Override
    public Book loadBook(int bookId) {
        Book book = SQLite.select()
                .from(Book.class)
                .where(Book_Table.id.is(bookId))
                .querySingle();
        Timber.d("loadCard() %s", book);
        return book;
    }

    @Override
    public void saveBook(Book book) {
        FastStoreModelTransaction<Book> transaction = FastStoreModelTransaction
                .insertBuilder(FlowManager.getModelAdapter(Book.class))
                .addAll(book)
                .build();
        DatabaseDefinition database = FlowManager.getDatabase(AppDatabase.class);
        database.executeTransaction(transaction);
        book.save();
    }

    @Override
    public void clean() {
        Delete.table(Book.class);
    }
}

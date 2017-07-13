package com.demo.dbflowsample.db;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.OneToMany;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

/**
 * author marat
 * since 13.07.2017.
 */

@Table(database = AppDatabase.class)
public class Book extends BaseModel {

    @PrimaryKey(autoincrement = true)
    int id;

    @Column
    String title;

    @Column
    int pages;

    // Authors
    List<Author> authors;

    @OneToMany(methods = OneToMany.Method.ALL, variableName = "authors")
    public List<Author> oneToManyAuthors() {
        if (authors == null) {
            authors = SQLite.select()
                    .from(Author.class)
                    .where(Author_Table.book_id.eq(id))
                    .queryList();
        }
        return authors;
    }

    @Override
    public boolean save() {
        boolean res = super.save();
        if (authors != null) {
            for (Author s : authors) {
                s.setBook(this);
                s.save();
            }
        }
        return res;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                ", authors=" + authors +
                '}';
    }
}
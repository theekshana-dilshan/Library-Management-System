package org.example.dao.custom;

import org.example.dao.CrudDAO;
import org.example.entity.Books;

import java.util.List;

public interface BooksDAO extends CrudDAO<Books> {
    boolean borrowBook(String id);

    public boolean returnBook(String id);

    Books getBookByTitle(String bookName);
}

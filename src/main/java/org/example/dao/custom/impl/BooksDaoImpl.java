package org.example.dao.custom.impl;

import org.example.config.FactoryConfiguration;
import org.example.dao.custom.BooksDAO;
import org.example.entity.Books;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class BooksDaoImpl implements BooksDAO {
    @Override
    public boolean add(Books entity) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Books> getAll() {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        Query<Books> query = session.createQuery("FROM Books", Books.class);
        List<Books> resultList = query.getResultList();

        transaction.commit();
        session.close();
        return resultList;
    }

    @Override
    public boolean update(Books entity) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        session.update(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean isExists(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Books book= session.get(Books.class,id);
        transaction.commit();
        session.close();

        return book != null;
    }

    @Override
    public Books search(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query<Books> query = session.createQuery("FROM Books WHERE id=:id",Books.class);
        query.setParameter("id",id);

        Books book = query.getSingleResult();

        transaction.commit();
        session.close();

        return book;
    }

    @Override
    public boolean delete(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Books book = session.get(Books.class, id);

        if (book!=null){
            session.delete(book);
            transaction.commit();
            session.close();
            return true;
        }
        return false;
    }

    @Override
    public boolean borrowBook(String id) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        Query query = session.createQuery("UPDATE Books SET availability = : availability WHERE id = :bookId");
        query.setParameter("availability",false);
        query.setParameter("bookId", id);
        int rowsUpdated = query.executeUpdate();
        transaction.commit();
        session.close();
        return rowsUpdated>0;
    }

    @Override
    public Books getBookByTitle(String bookName) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query<Books> query = session.createQuery("FROM Books WHERE title= : bookName",Books.class);
        query.setParameter("bookName", bookName);

        Books book = query.getSingleResult();

        transaction.commit();
        session.close();

        return book;
    }
}

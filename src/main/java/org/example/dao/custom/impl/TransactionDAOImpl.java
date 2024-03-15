package org.example.dao.custom.impl;

import org.example.config.FactoryConfiguration;
import org.example.controller.UserLoginFormController;
import org.example.dao.custom.TransactionDAO;
import org.example.entity.CustomEntity;
import org.example.entity.Transaction;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionDAOImpl implements TransactionDAO {
    @Override
    public boolean add(Transaction entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        org.hibernate.Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Transaction> getAll() {
        Session session= FactoryConfiguration.getInstance().getSession();
        org.hibernate.Transaction transaction=session.beginTransaction();

        Query<Transaction> query = session.createQuery("FROM Transaction ", Transaction.class);
        List<Transaction> resultList = query.getResultList();

        transaction.commit();
        session.close();
        return resultList;
    }

    @Override
    public boolean update(Transaction entity) {
        return false;
    }

    @Override
    public boolean updateStatus(String id) {
        Session session= FactoryConfiguration.getInstance().getSession();
        org.hibernate.Transaction transaction=session.beginTransaction();

        Query query = session.createQuery("UPDATE Transaction SET status = : status WHERE transactionId = :transactionId");
        query.setParameter("status","Returned");
        query.setParameter("transactionId", id);
        int rowsUpdated = query.executeUpdate();
        transaction.commit();
        session.close();
        return rowsUpdated>0;
    }

    @Override
    public boolean isExists(String id) {
        return false;
    }

    @Override
    public Transaction search(String id) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    public List<CustomEntity> getUserTransaction() {
        Session session = FactoryConfiguration.getInstance().getSession();
        org.hibernate.Transaction transaction = session.beginTransaction();

        Query<Object[]> query = session.createQuery(
                "SELECT t.books.id, t.books.title,t.books.author, t.books.genre, t.borrowingDate, t.returnDate, t.status " +
                        "FROM Transaction t " +
                        "WHERE t.user.userId = :userId",
                Object[].class
        ).setParameter("userId", UserLoginFormController.userId);

        List<Object[]> resultList = query.getResultList();
        List<CustomEntity> customEntities = new ArrayList<>();

        for (Object[] result : resultList) {
            String bookId = (String) result[0];
            String title = (String) result[1];
            String author= (String) result[2];
            String genre = (String) result[3];
            Date borrowingDate = (Date) result[4];
            Date returnDate = (Date) result[5];
            String status = (String) result[6];

            CustomEntity customEntity = new CustomEntity(bookId, title, author,genre, borrowingDate, returnDate, status);
            customEntities.add(customEntity);
        }

        transaction.commit();
        session.close();
        return customEntities;
    }
}

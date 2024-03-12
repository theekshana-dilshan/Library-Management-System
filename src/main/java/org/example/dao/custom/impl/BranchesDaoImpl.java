package org.example.dao.custom.impl;

import org.example.config.FactoryConfiguration;
import org.example.dao.custom.BranchesDAO;
import org.example.entity.Branches;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class BranchesDaoImpl implements BranchesDAO {
    @Override
    public boolean add(Branches entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Branches> getAll() {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        Query<Branches> query = session.createQuery("FROM Branches ", Branches.class);
        List<Branches> resultList = query.getResultList();

        transaction.commit();
        session.close();
        return resultList;
    }

    @Override
    public boolean update(Branches entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean isExists(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Branches branch= session.get(Branches.class,id);
        transaction.commit();
        session.close();

        return branch != null;
    }

    @Override
    public Branches search(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query<Branches> query = session.createQuery("FROM Branches WHERE code=:id",Branches.class);
        query.setParameter("id",id);

        Branches branch = query.getSingleResult();

        transaction.commit();
        session.close();

        return branch;
    }

    @Override
    public boolean delete(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Branches branch=session.get(Branches.class,id);

        if (branch!=null){
            session.delete(branch);
            transaction.commit();
            session.close();
            return true;
        }
        return false;
    }
}

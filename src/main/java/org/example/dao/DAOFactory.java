package org.example.dao;


import org.example.dao.custom.impl.AdminDaoImpl;
import org.example.dao.custom.impl.BooksDaoImpl;
import org.example.dao.custom.impl.BranchesDaoImpl;
import org.example.dao.custom.impl.UserDaoImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){
    }
    public static DAOFactory getDaoFactory(){
        return (daoFactory==null)?daoFactory=new DAOFactory():daoFactory;
    }
    public enum DAOTypes {
        ADMIN, USER, BOOKS, BRANCHES
    }
    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case ADMIN:
                return new AdminDaoImpl();
            case USER:
                return new UserDaoImpl();
            case BOOKS:
                return new BooksDaoImpl();
            case BRANCHES:
                return new BranchesDaoImpl();
            default:
                return null;
        }
    }
}

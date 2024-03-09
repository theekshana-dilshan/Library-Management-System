package org.example.bo;


import org.example.bo.custom.impl.AdminBoImpl;
import org.example.bo.custom.impl.BooksBoImpl;
import org.example.bo.custom.impl.BranchesBoImpl;
import org.example.bo.custom.impl.UserBoImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){

    }
    public static BOFactory getBOFactory(){
        return (boFactory==null)?boFactory=new BOFactory():boFactory;
    }
    public enum BOTypes{
        ADMIN, USER, BOOKS, BRANCHES
    }
    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case ADMIN:
                return new AdminBoImpl();
            case USER:
                return new UserBoImpl();
            case BOOKS:
                return new BooksBoImpl();
            case BRANCHES:
                return new BranchesBoImpl();
            default:
                return null;
        }
    }
}

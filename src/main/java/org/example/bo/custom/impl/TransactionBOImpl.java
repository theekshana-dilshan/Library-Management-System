package org.example.bo.custom.impl;

import org.example.bo.custom.TransactionBO;
import org.example.dao.DAOFactory;
import org.example.dao.custom.TransactionDAO;
import org.example.dto.TransactionDto;
import org.example.dto.UserTransactionDto;
import org.example.entity.CustomEntity;
import org.example.entity.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionBOImpl implements TransactionBO {

    TransactionDAO transactionDAO= (TransactionDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.TRANSACTION);
    @Override
    public boolean saveTransaction(TransactionDto dto) {
        return transactionDAO.add(new Transaction(dto.getTransactionId(),dto.getBorrowingDate(),dto.getReturnDate()
        ,dto.getUser(),dto.getBook(), dto.getStatus()));
    }

    @Override
    public List<TransactionDto> getTransactions() {
        List<Transaction> all = transactionDAO.getAll();

        List<TransactionDto> allTransaction = new ArrayList<>();

        for (Transaction transaction : all) {
            allTransaction.add(new TransactionDto(transaction.getTransactionId(),transaction.getBorrowingDate(),transaction.getReturnDate(),
                    transaction.getUser(),transaction.getBooks(),transaction.getStatus()));
        }
        return allTransaction;
    }

    @Override
    public List<UserTransactionDto> getUserTransactions() {
        List<CustomEntity> all = transactionDAO.getUserTransaction();

        List<UserTransactionDto> allTransaction = new ArrayList<>();

        for ( CustomEntity transaction : all) {
            allTransaction.add(new UserTransactionDto(transaction.getBookId(),transaction.getTitle(),transaction.getAuthor(), transaction.getGenre(),
                    transaction.getBorrowingDate(),transaction.getReturnDate(),transaction.getStatus()));
        }
        return allTransaction;
    }
}

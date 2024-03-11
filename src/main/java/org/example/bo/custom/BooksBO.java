package org.example.bo.custom;

import org.example.bo.SuperBO;
import org.example.dto.BooksDTO;

import java.util.List;

public interface BooksBO extends SuperBO {
    boolean addBook(BooksDTO dto);
    List<BooksDTO> getAllBooks();
    boolean updateBook(BooksDTO dto);
    boolean isExistBook(String id);
    BooksDTO searchBook(String id);
    boolean deleteBook(String id);
    boolean borrowBook(String id);
}

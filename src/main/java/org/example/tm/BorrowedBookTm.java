package org.example.tm;

import lombok.*;

import java.awt.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BorrowedBookTm {
    private String bookId;
    private String title;
    private String author;
    private String genre;
    private String borrowDate;
    private String returnDate;
    private Button returnBook;
}

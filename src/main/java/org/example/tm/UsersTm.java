package org.example.tm;

import lombok.*;

import java.awt.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsersTm {
    private String userId;
    private String userName;
    private String email;
    private String borrowedBooks;
    private String booksToReturn;
    private Button delete;
}

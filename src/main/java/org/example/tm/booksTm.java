package org.example.tm;

import lombok.*;

import java.awt.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class booksTm {
    private String bookId;
    private String title;
    private String author;
    private String genre;
    private String availability;
    private Button remove;
}

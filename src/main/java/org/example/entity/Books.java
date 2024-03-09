package org.example.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Books {
    private String id;
    private String title;
    private String author;
    private String genre;
}

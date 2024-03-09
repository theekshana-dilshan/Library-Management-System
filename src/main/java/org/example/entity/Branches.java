package org.example.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Branches {
    private String code;
    private String location;
    private String contactNumber;
    private String status;
}

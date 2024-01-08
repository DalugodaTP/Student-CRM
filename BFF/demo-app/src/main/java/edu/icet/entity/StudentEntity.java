package edu.icet.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private String firstName;
    private String lastName;
    private String contactNumber;

}

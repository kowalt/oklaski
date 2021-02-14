package com.example.oklaski.entites;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name="testers")
public class Tester {

    @Id
    @Column(name = "tester_id", unique = true, nullable = false)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDateTime lastLogin;
    private String country;
}

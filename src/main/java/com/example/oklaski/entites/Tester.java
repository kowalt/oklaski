package com.example.oklaski.entites;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Tester {

    @Id
    @Column(name = "testerId")
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDateTime lastLogin;
    private String country;
    @OneToMany
    private List<Bug> bugList;
    @ManyToMany
    private List<Device> deviceList;
}

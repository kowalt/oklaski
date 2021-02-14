package com.example.oklaski.entites;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name="bugs")
@Getter
public class Bug {
    @Id
    @Column(name = "bug_id", unique = true, nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name= "device_id")
    private Device device;
    @OneToOne
    @JoinColumn(name = "tester_id")
    private Tester tester;
}

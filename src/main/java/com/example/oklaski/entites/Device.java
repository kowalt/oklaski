package com.example.oklaski.entites;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Device {

    @Id()
    private Long id;
    private String description;
}

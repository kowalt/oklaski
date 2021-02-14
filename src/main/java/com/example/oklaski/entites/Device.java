package com.example.oklaski.entites;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="devices")
@Getter
public class Device {

    @Id
    @Column(name = "device_id", unique = true, nullable = false)
    private Long id;
    private String description;
}

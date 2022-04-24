package com.example.demos.entity;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="fly")
public class Fly {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private int maximumFuel;
    @Column
    private int fuelConsumption;
    
    
}

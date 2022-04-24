package com.example.demos.entity;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="airport")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String country;
    
    
}

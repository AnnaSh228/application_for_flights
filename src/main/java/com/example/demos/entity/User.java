package com.example.demos.entity;

import javax.persistence.*;
import java.util.*;
import lombok.Data;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable=false, unique=true)
    private String username;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false, length = 3000)
    private String password;
    @Column(nullable = false, unique=true, length=10)
    private int passportNumber;
    @Column(nullable = false, unique=true)
    private String address;
    @Column(nullable = false, unique=true, length=16)
    private int bankcardNumber;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false, unique=true, length=11)
    private int phoneNumber;

    @Column
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Flight> userFlight=new ArrayList<>();

    @Column (updatable=false)
    @JsonFormat(pattern = "yyyy-mm-dd")
    private LocalDateTime createdDate;
    
    @PrePersist
    protected void onCreate(){
        this.createdDate = LocalDateTime.now();
    }

    public Object setUserRole() {
        return null;
    }
}

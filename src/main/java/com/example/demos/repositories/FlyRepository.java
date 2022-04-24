package com.example.demos.repositories;

import com.example.demos.entity.Fly;
import com.example.demos.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlyRepository extends JpaRepository<Fly, Long>{
   
}

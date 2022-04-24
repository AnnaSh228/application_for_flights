package com.example.demos.repositories;

import java.util.List;

import com.example.demos.entity.Fly;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlyRepository extends JpaRepository<Fly, Long>{
    Fly findFlyByMaximumFuel(int maximumFuel);
}

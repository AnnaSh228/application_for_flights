package com.example.demos.repositories;
import com.example.demos.entity.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface RoleRepository extends JpaRepository <Role, Long>{
    
}

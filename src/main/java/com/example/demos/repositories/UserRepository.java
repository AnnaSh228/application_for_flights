package com.example.demos.repositories;
import java.util.List;
import java.util.Optional;

import com.example.demos.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
     User findUserByUsername(String username);
     Optional<User> findUserById(long id);
     List <User> findAllByOrderByCreatedDateDesc();
     void deleteUserById(long id);
     
}

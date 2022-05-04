package com.example.demos.security;

import com.example.demos.entity.User;
import com.example.demos.repositories.UserRepository;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private Logger LOG = LoggerFactory.getLogger(CustomUserDetailService.class);

    private final UserRepository userRepository;
    @PersistenceContext
    private EntityManager entityManager;


    @Autowired
    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findUserByUsername(username);
        if(user == null){
            LOG.error("User with {} username not found", username);
            throw new UsernameNotFoundException("User not found");
        }
        return build(user);
    }

    public User loadUserById(Long id) {
        return null;
    }


    public CustomUserDetail build(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : user.getRole()){
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role);
            authorities.add(simpleGrantedAuthority);
        }

        return new CustomUserDetail(
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                authorities);
    }
}


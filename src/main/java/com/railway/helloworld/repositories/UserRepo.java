package com.railway.helloworld.repositories;

import com.railway.helloworld.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);
    User findByid(Long id);
}


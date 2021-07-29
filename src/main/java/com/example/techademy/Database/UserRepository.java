package com.example.techademy.Database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {

    public User findByEmail(String email);
    public List<User> findByRole(String role);
}

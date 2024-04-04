package com.possacode.digitalbanking.repository;


import com.possacode.digitalbanking.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

package com.smirnov3308.cinemadb.repository;

import com.smirnov3308.cinemadb.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
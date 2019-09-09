package com.smirnov3308.cinemadb.repository;

import com.smirnov3308.cinemadb.domain.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Long> {
    Director findByName(String name);
}
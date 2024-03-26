package com.springboot.architectural.repository;

import com.springboot.architectural.entity.Movie;
import com.springboot.architectural.entity.Movie_Category;
import com.springboot.architectural.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}

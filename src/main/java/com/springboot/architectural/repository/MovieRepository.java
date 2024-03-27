package com.springboot.architectural.repository;

import com.springboot.architectural.entity.Movie;
import com.springboot.architectural.entity.Movie_Category;
import com.springboot.architectural.entity.Role;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Query("SELECT r FROM Movie r WHERE CONCAT(r.id, ' ', r.name) LIKE %?1%")
    public List<Movie> findAllFilter(String searchContent, Sort pageable);
}

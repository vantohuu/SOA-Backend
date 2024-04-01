package com.springboot.architectural.repository;

import com.springboot.architectural.entity.Movie_User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MovieUserRepository extends JpaRepository<Movie_User, String> {
    @Query("SELECT r FROM Movie_User r WHERE CONCAT(r.id, ' ', r.name) LIKE %?1%")
    public List<Movie_User> findAllFilter(String searchContent, Sort pageable);

    public Optional<Movie_User> findByEmail(String email);
}

package com.springboot.architectural.repository;

import com.springboot.architectural.entity.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieCollectionRepository extends JpaRepository<Movie_Collection, Integer> {
    List<Movie_Collection> findByMovieAndMovieUser(Movie movie, Movie_User movieUser);
    List<Movie_Collection> findByMovieUser(Movie_User movieUser);

}

package com.springboot.architectural.repository;

import com.springboot.architectural.entity.Movie;
import com.springboot.architectural.entity.Movie_Buy;
import com.springboot.architectural.entity.Movie_Collection;
import com.springboot.architectural.entity.Movie_User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovieBuyRepository extends JpaRepository<Movie_Buy, Integer> {
    Optional<Movie_Buy> findByMovieAndMovieUser(Movie movie, Movie_User movieUser);
    List<Movie_Buy> findByMovieUser(Movie_User movieUser);

}

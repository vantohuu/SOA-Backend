package com.springboot.architectural.repository;

import com.springboot.architectural.entity.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MoviePersonRepository extends JpaRepository<Movie_Person, Integer> {
    List<Movie_Person> findByMovieAndPerson(Movie movie, Person person);
}

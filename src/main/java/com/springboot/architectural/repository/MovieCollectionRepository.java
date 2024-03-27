package com.springboot.architectural.repository;

import com.springboot.architectural.entity.Movie_Collection;
import com.springboot.architectural.entity.Movie_Person;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieCollectionRepository extends JpaRepository<Movie_Collection, String> {

}

package com.springboot.architectural.repository;

import com.springboot.architectural.entity.Category;
import com.springboot.architectural.entity.Movie;
import com.springboot.architectural.entity.Movie_Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieCategoryRepository extends JpaRepository<Movie_Category, Integer> {
    List<Movie_Category> findByMovieAndCategory(Movie movie, Category category);
}

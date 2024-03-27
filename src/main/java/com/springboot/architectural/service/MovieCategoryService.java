package com.springboot.architectural.service;

import com.springboot.architectural.dto.Movie_CategoryDTO;

import java.util.Date;
import java.util.List;

public interface MovieCategoryService {
    Movie_CategoryDTO getById(int id);
    List<Movie_CategoryDTO> getAll();
    Movie_CategoryDTO add(Movie_CategoryDTO movieCategoryDTO);
    Movie_CategoryDTO update(Movie_CategoryDTO movieCategoryDTO);
    boolean delete(Integer id);

}

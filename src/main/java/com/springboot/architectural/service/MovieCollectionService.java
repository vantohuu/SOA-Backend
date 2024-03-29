package com.springboot.architectural.service;

import com.springboot.architectural.dto.Movie_CategoryDTO;
import com.springboot.architectural.dto.Movie_CollectionDTO;

import java.util.List;

public interface MovieCollectionService {
    Movie_CollectionDTO getById(Integer id);
    List<Movie_CollectionDTO> getAll();
    Movie_CollectionDTO add(Movie_CollectionDTO movieCollectionDTO);
    Movie_CollectionDTO update(Movie_CollectionDTO movieCollectionDTO);
    boolean delete(Integer id);

}

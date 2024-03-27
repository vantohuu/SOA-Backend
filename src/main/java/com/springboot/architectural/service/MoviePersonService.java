package com.springboot.architectural.service;

import com.springboot.architectural.dto.Movie_CollectionDTO;
import com.springboot.architectural.dto.Movie_PersonDTO;
import com.springboot.architectural.entity.Movie_Person;

import java.util.List;

public interface MoviePersonService {
    Movie_PersonDTO getById(int id);
    List<Movie_PersonDTO> getAll();
    Movie_PersonDTO add(Movie_PersonDTO moviePersonDTO);
    Movie_PersonDTO update(Movie_PersonDTO moviePersonDTO);
    boolean delete(Integer id);

}

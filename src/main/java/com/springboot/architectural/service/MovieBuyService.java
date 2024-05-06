package com.springboot.architectural.service;

import com.springboot.architectural.dto.Movie_BuyDTO;
import com.springboot.architectural.dto.Movie_CollectionDTO;

import java.util.List;

public interface MovieBuyService {
    Movie_BuyDTO getById(Integer id);
    List<Movie_BuyDTO> getAll();
    List<Movie_BuyDTO> getAllByMovieUser(String username);
    Movie_BuyDTO add(Movie_BuyDTO movieBuyDTO);
    Movie_BuyDTO update(Movie_BuyDTO movieBuyDTO);
    boolean delete(Integer id);


    boolean checkMovieBuyIsExists(Integer movieId, String username);

    boolean deleteMovieBuyByMovieAndUser(Integer movieId, String username);
}

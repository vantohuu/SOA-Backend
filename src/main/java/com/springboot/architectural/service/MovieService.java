package com.springboot.architectural.service;

import com.springboot.architectural.dto.MovieDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MovieService {
    MovieDTO getById(Integer id);
    List<MovieDTO> getAll(String searchContent,String sortField,  String typeSort);
    MovieDTO add(MovieDTO movieDTO);
    MovieDTO update(MovieDTO movieDTO);
    boolean delete(Integer id);

    boolean uploadImg(MultipartFile multipartFile, Integer movie_id);
}

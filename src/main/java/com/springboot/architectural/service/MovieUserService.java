package com.springboot.architectural.service;

import com.springboot.architectural.dto.Movie_UserDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MovieUserService {
    Movie_UserDTO getById(String username);
    List<Movie_UserDTO> getAll(String searchContent, String sortField, String typeSort);
    Movie_UserDTO add(Movie_UserDTO movieUserDTO);
    Movie_UserDTO update(Movie_UserDTO movieUserDTO);
    boolean delete(String username);
    boolean uploadImg(MultipartFile multipartFile, String username);
}

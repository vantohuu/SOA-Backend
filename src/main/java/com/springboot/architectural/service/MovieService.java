package com.springboot.architectural.service;

import com.springboot.architectural.dto.MovieDTO;
import com.springboot.architectural.entity.Category;
import com.springboot.architectural.entity.Movie;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MovieService {
    MovieDTO getById(Integer id);
    List<MovieDTO> getAll(String searchContent,String sortField,  String typeSort);
    List<MovieDTO> getAllByCategory(String searchContent,String sortField, String typeSort, Integer category_id);
    List<MovieDTO> getAllByTopNewMovie(Integer top);

    MovieDTO add(MovieDTO movieDTO);
    MovieDTO update(MovieDTO movieDTO);
    boolean delete(Integer id);
    boolean uploadImg(MultipartFile multipartFile, Integer movie_id);

    List<MovieDTO> getPhimBo();

    List<MovieDTO> getPhimLe();
    public List<MovieDTO> findAllWithPaginationAndSorting(String searchContent, int offset, int pageSize, String field);

    public List<MovieDTO> findByCategoryWithPaginationAndSorting(String searchContent,Integer category_id,int offset, int pageSize, String field);
    public List<MovieDTO> findByCountryWithPaginationAndSorting(String searchContent,Integer category_id,int offset, int pageSize, String field);

    public List<MovieDTO> getRandomMovie(Integer top);

}

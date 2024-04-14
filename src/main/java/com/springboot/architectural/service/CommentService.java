package com.springboot.architectural.service;

import com.springboot.architectural.dto.CommentDTO;
import com.springboot.architectural.dto.MovieDTO;

import java.util.List;

public interface CommentService {
    CommentDTO getById(int id);
    List<CommentDTO> getAll();
    CommentDTO add(CommentDTO commentDTO);
    CommentDTO update(CommentDTO commentDTOs);
    public List<CommentDTO> findByMovieWithPaginationAndSorting(String searchContent, Integer category_id, int offset, int pageSize, String field);

    boolean delete(Integer id);
}

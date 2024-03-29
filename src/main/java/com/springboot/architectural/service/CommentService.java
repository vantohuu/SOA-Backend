package com.springboot.architectural.service;

import com.springboot.architectural.dto.CommentDTO;

import java.util.List;

public interface CommentService {
    CommentDTO getById(int id);
    List<CommentDTO> getAll();
    CommentDTO add(CommentDTO commentDTO);
    CommentDTO update(CommentDTO commentDTOs);
    boolean delete(Integer id);
}

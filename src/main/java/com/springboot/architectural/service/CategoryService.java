package com.springboot.architectural.service;

import com.springboot.architectural.dto.CategoryDTO;
import com.springboot.architectural.dto.RoleDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO getById(int id);
    List<CategoryDTO> getAll();
    CategoryDTO add(CategoryDTO categoryDTO);
    CategoryDTO update(CategoryDTO categoryDTO);
    boolean delete(Integer id);
}

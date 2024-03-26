package com.springboot.architectural.service.imp;

import com.springboot.architectural.dto.CategoryDTO;
import com.springboot.architectural.dto.RoleDTO;
import com.springboot.architectural.entity.Category;
import com.springboot.architectural.entity.Role;
import com.springboot.architectural.mapper.CategoryMapper;
import com.springboot.architectural.mapper.RoleMapper;
import com.springboot.architectural.repository.CategoryRepository;
import com.springboot.architectural.repository.RoleRepository;
import com.springboot.architectural.service.CategoryService;
import com.springboot.architectural.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImp implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDTO getById(int id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.map(CategoryMapper.INSTANCE::categoryToCategoryDto).orElse(null);
    }

    public List<CategoryDTO> getAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(CategoryMapper.INSTANCE::categoryToCategoryDto).collect(Collectors.toList());
    }

    @Override
    public CategoryDTO add(CategoryDTO category) {
        Category categoryEntity = CategoryMapper.INSTANCE.categoryDtoToCategory(category);
        if (category.getName() == null ) return  null;
        return  CategoryMapper.INSTANCE.categoryToCategoryDto(categoryRepository.save(categoryEntity));
    }

    @Override
    public CategoryDTO update(CategoryDTO categoryDTO) {
        Optional<Category> checkRR = categoryRepository.findById(categoryDTO.getCategory_id());
        if (checkRR.isEmpty()) return null;
        Category roomRegisEntity = CategoryMapper.INSTANCE.categoryDtoToCategory(categoryDTO);
        return  CategoryMapper.INSTANCE.categoryToCategoryDto(categoryRepository.save(roomRegisEntity));
    }

    @Override
    public boolean delete(Integer id) {
        Optional<Category> c = categoryRepository.findById(id);
        if (c.isPresent())
        {
            categoryRepository.delete(c.get());
            return true;
        }
        return false;
    }
}

package com.springboot.architectural.mapper;

import com.springboot.architectural.dto.CategoryDTO;
import com.springboot.architectural.dto.RoleDTO;
import com.springboot.architectural.entity.Category;
import com.springboot.architectural.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class );
    CategoryDTO categoryToCategoryDto(Category category);
    Category categoryDtoToCategory(CategoryDTO categoryDto);
}

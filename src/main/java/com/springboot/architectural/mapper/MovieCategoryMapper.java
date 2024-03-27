package com.springboot.architectural.mapper;

import com.springboot.architectural.dto.Movie_CategoryDTO;
import com.springboot.architectural.dto.Movie_CollectionDTO;
import com.springboot.architectural.entity.Movie_Category;
import com.springboot.architectural.entity.Movie_Collection;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieCategoryMapper {
    MovieCategoryMapper INSTANCE = Mappers.getMapper(MovieCategoryMapper.class );
    Movie_CategoryDTO movieCategoryToMovieCategoryDto(Movie_Category movieCategory);
    Movie_Category movieCategoryDtoToMovieCategory(Movie_CategoryDTO movieCategoryDTO);
}

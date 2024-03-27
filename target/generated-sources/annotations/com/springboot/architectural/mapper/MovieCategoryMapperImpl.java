package com.springboot.architectural.mapper;

import com.springboot.architectural.dto.Movie_CategoryDTO;
import com.springboot.architectural.entity.Movie_Category;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-27T17:32:10+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
public class MovieCategoryMapperImpl implements MovieCategoryMapper {

    @Override
    public Movie_CategoryDTO movieCategoryToMovieCategoryDto(Movie_Category movieCategory) {
        if ( movieCategory == null ) {
            return null;
        }

        Movie_CategoryDTO movie_CategoryDTO = new Movie_CategoryDTO();

        movie_CategoryDTO.setId( movieCategory.getId() );
        movie_CategoryDTO.setMovie( movieCategory.getMovie() );
        movie_CategoryDTO.setCategory( movieCategory.getCategory() );

        return movie_CategoryDTO;
    }

    @Override
    public Movie_Category movieCategoryDtoToMovieCategory(Movie_CategoryDTO movieCategoryDTO) {
        if ( movieCategoryDTO == null ) {
            return null;
        }

        Movie_Category movie_Category = new Movie_Category();

        movie_Category.setId( movieCategoryDTO.getId() );
        movie_Category.setMovie( movieCategoryDTO.getMovie() );
        movie_Category.setCategory( movieCategoryDTO.getCategory() );

        return movie_Category;
    }
}

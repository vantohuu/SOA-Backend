package com.springboot.architectural.mapper;

import com.springboot.architectural.dto.Movie_CategoryDTO;
import com.springboot.architectural.entity.Category;
import com.springboot.architectural.entity.Movie;
import com.springboot.architectural.entity.Movie_Category;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-10T19:49:26+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
public class MovieCategoryMapperImpl implements MovieCategoryMapper {

    @Override
    public Movie_CategoryDTO movieCategoryToMovieCategoryDto(Movie_Category movieCategory) {
        if ( movieCategory == null ) {
            return null;
        }

        Movie_CategoryDTO movie_CategoryDTO = new Movie_CategoryDTO();

        movie_CategoryDTO.setMovieId( movieCategoryMovieMovieId( movieCategory ) );
        movie_CategoryDTO.setCategoryId( movieCategoryCategoryCategoryId( movieCategory ) );
        movie_CategoryDTO.setId( movieCategory.getId() );

        return movie_CategoryDTO;
    }

    @Override
    public Movie_Category movieCategoryDtoToMovieCategory(Movie_CategoryDTO movieCategoryDTO) {
        if ( movieCategoryDTO == null ) {
            return null;
        }

        Movie_Category movie_Category = new Movie_Category();

        movie_Category.setId( movieCategoryDTO.getId() );

        return movie_Category;
    }

    private Integer movieCategoryMovieMovieId(Movie_Category movie_Category) {
        if ( movie_Category == null ) {
            return null;
        }
        Movie movie = movie_Category.getMovie();
        if ( movie == null ) {
            return null;
        }
        Integer movieId = movie.getMovieId();
        if ( movieId == null ) {
            return null;
        }
        return movieId;
    }

    private Integer movieCategoryCategoryCategoryId(Movie_Category movie_Category) {
        if ( movie_Category == null ) {
            return null;
        }
        Category category = movie_Category.getCategory();
        if ( category == null ) {
            return null;
        }
        Integer categoryId = category.getCategoryId();
        if ( categoryId == null ) {
            return null;
        }
        return categoryId;
    }
}

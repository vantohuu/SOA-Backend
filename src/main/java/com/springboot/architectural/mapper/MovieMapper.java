package com.springboot.architectural.mapper;

import com.springboot.architectural.dto.MovieDTO;
import com.springboot.architectural.entity.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class );
    @Mapping(target = "countryId", source = "movie.country.countryId")
    MovieDTO movieToMovieDto(Movie movie);
    Movie movieDtoToMovie(MovieDTO movieDTO);
}

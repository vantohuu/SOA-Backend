package com.springboot.architectural.mapper;

import com.springboot.architectural.dto.MovieDTO;
import com.springboot.architectural.dto.Movie_PersonDTO;
import com.springboot.architectural.entity.Movie;
import com.springboot.architectural.entity.Movie_Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MoviePersonMapper {
    MoviePersonMapper INSTANCE = Mappers.getMapper(MoviePersonMapper.class );
    Movie_PersonDTO moviePersonToMoviePersonDto(Movie_Person moviePerson);
    Movie_Person moviePersonDtoToMoviePerson(Movie_PersonDTO moviePersonDTO);
}

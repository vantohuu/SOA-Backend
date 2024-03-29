package com.springboot.architectural.mapper;

import com.springboot.architectural.dto.MovieDTO;
import com.springboot.architectural.dto.Movie_PersonDTO;
import com.springboot.architectural.entity.Movie;
import com.springboot.architectural.entity.Movie_Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MoviePersonMapper {
    MoviePersonMapper INSTANCE = Mappers.getMapper(MoviePersonMapper.class );
    @Mapping(target = "movieId", source = "moviePerson.movie.movieId")
    @Mapping(target = "movieName", source = "moviePerson.movie.name")
    @Mapping(target = "personId", source = "moviePerson.person.personId")
    Movie_PersonDTO moviePersonToMoviePersonDto(Movie_Person moviePerson);
    Movie_Person moviePersonDtoToMoviePerson(Movie_PersonDTO moviePersonDTO);
}

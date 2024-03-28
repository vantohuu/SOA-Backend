package com.springboot.architectural.mapper;

import com.springboot.architectural.dto.Movie_PersonDTO;
import com.springboot.architectural.entity.Movie_Person;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-28T15:12:45+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
public class MoviePersonMapperImpl implements MoviePersonMapper {

    @Override
    public Movie_PersonDTO moviePersonToMoviePersonDto(Movie_Person moviePerson) {
        if ( moviePerson == null ) {
            return null;
        }

        Movie_PersonDTO movie_PersonDTO = new Movie_PersonDTO();

        movie_PersonDTO.setId( moviePerson.getId() );
        movie_PersonDTO.setMovie( moviePerson.getMovie() );
        movie_PersonDTO.setPerson( moviePerson.getPerson() );

        return movie_PersonDTO;
    }

    @Override
    public Movie_Person moviePersonDtoToMoviePerson(Movie_PersonDTO moviePersonDTO) {
        if ( moviePersonDTO == null ) {
            return null;
        }

        Movie_Person movie_Person = new Movie_Person();

        movie_Person.setId( moviePersonDTO.getId() );
        movie_Person.setMovie( moviePersonDTO.getMovie() );
        movie_Person.setPerson( moviePersonDTO.getPerson() );

        return movie_Person;
    }
}

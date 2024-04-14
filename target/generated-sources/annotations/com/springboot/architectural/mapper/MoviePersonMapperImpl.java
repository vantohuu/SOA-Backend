package com.springboot.architectural.mapper;

import com.springboot.architectural.dto.CountryDTO;
import com.springboot.architectural.dto.Movie_PersonDTO;
import com.springboot.architectural.dto.PersonDTO;
import com.springboot.architectural.entity.Country;
import com.springboot.architectural.entity.Movie;
import com.springboot.architectural.entity.Movie_Person;
import com.springboot.architectural.entity.Person;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-14T23:25:59+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
public class MoviePersonMapperImpl implements MoviePersonMapper {

    @Override
    public Movie_PersonDTO moviePersonToMoviePersonDto(Movie_Person moviePerson) {
        if ( moviePerson == null ) {
            return null;
        }

        Movie_PersonDTO movie_PersonDTO = new Movie_PersonDTO();

        movie_PersonDTO.setMovieId( moviePersonMovieMovieId( moviePerson ) );
        movie_PersonDTO.setMovieName( moviePersonMovieName( moviePerson ) );
        movie_PersonDTO.setPersonId( moviePersonPersonPersonId( moviePerson ) );
        movie_PersonDTO.setId( moviePerson.getId() );
        movie_PersonDTO.setPerson( personToPersonDTO( moviePerson.getPerson() ) );

        return movie_PersonDTO;
    }

    @Override
    public Movie_Person moviePersonDtoToMoviePerson(Movie_PersonDTO moviePersonDTO) {
        if ( moviePersonDTO == null ) {
            return null;
        }

        Movie_Person movie_Person = new Movie_Person();

        movie_Person.setId( moviePersonDTO.getId() );
        movie_Person.setPerson( personDTOToPerson( moviePersonDTO.getPerson() ) );

        return movie_Person;
    }

    private Integer moviePersonMovieMovieId(Movie_Person movie_Person) {
        if ( movie_Person == null ) {
            return null;
        }
        Movie movie = movie_Person.getMovie();
        if ( movie == null ) {
            return null;
        }
        Integer movieId = movie.getMovieId();
        if ( movieId == null ) {
            return null;
        }
        return movieId;
    }

    private String moviePersonMovieName(Movie_Person movie_Person) {
        if ( movie_Person == null ) {
            return null;
        }
        Movie movie = movie_Person.getMovie();
        if ( movie == null ) {
            return null;
        }
        String name = movie.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Integer moviePersonPersonPersonId(Movie_Person movie_Person) {
        if ( movie_Person == null ) {
            return null;
        }
        Person person = movie_Person.getPerson();
        if ( person == null ) {
            return null;
        }
        Integer personId = person.getPersonId();
        if ( personId == null ) {
            return null;
        }
        return personId;
    }

    protected CountryDTO countryToCountryDTO(Country country) {
        if ( country == null ) {
            return null;
        }

        CountryDTO countryDTO = new CountryDTO();

        countryDTO.setCountryId( country.getCountryId() );
        countryDTO.setName( country.getName() );

        return countryDTO;
    }

    protected PersonDTO personToPersonDTO(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        personDTO.setPersonId( person.getPersonId() );
        personDTO.setName( person.getName() );
        personDTO.setGender( person.getGender() );
        personDTO.setDayOfBirth( person.getDayOfBirth() );
        personDTO.setImage( person.getImage() );
        personDTO.setDescribe( person.getDescribe() );
        personDTO.setCountry( countryToCountryDTO( person.getCountry() ) );

        return personDTO;
    }

    protected Country countryDTOToCountry(CountryDTO countryDTO) {
        if ( countryDTO == null ) {
            return null;
        }

        Country country = new Country();

        country.setCountryId( countryDTO.getCountryId() );
        country.setName( countryDTO.getName() );

        return country;
    }

    protected Person personDTOToPerson(PersonDTO personDTO) {
        if ( personDTO == null ) {
            return null;
        }

        Person person = new Person();

        person.setPersonId( personDTO.getPersonId() );
        person.setName( personDTO.getName() );
        person.setGender( personDTO.getGender() );
        person.setDayOfBirth( personDTO.getDayOfBirth() );
        person.setImage( personDTO.getImage() );
        person.setDescribe( personDTO.getDescribe() );
        person.setCountry( countryDTOToCountry( personDTO.getCountry() ) );

        return person;
    }
}

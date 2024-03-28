package com.springboot.architectural.mapper;

import com.springboot.architectural.dto.CategoryDTO;
import com.springboot.architectural.dto.EpisodeDTO;
import com.springboot.architectural.dto.MovieDTO;
import com.springboot.architectural.dto.PersonDTO;
import com.springboot.architectural.entity.Category;
import com.springboot.architectural.entity.Country;
import com.springboot.architectural.entity.Episode;
import com.springboot.architectural.entity.Movie;
import com.springboot.architectural.entity.Person;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-28T20:31:26+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
public class MovieMapperImpl implements MovieMapper {

    @Override
    public MovieDTO movieToMovieDto(Movie movie) {
        if ( movie == null ) {
            return null;
        }

        MovieDTO movieDTO = new MovieDTO();

        movieDTO.setCountry_id( movieCountryCountry_id( movie ) );
        movieDTO.setMovie_id( movie.getMovie_id() );
        movieDTO.setName( movie.getName() );
        movieDTO.setMovie_content( movie.getMovie_content() );
        movieDTO.setEpisodes( movie.getEpisodes() );
        movieDTO.setMovie_schedule( movie.getMovie_schedule() );
        movieDTO.setImage( movie.getImage() );
        movieDTO.setCountry( movie.getCountry() );
        movieDTO.setStar( movie.getStar() );
        movieDTO.setPrice( movie.getPrice() );
        movieDTO.setViews( movie.getViews() );
        movieDTO.setStatus( movie.getStatus() );
        movieDTO.setEpisodeList( episodeListToEpisodeDTOList( movie.getEpisodeList() ) );
        movieDTO.setCategories( categorySetToCategoryDTOList( movie.getCategories() ) );
        movieDTO.setPersons( personSetToPersonDTOList( movie.getPersons() ) );

        return movieDTO;
    }

    @Override
    public Movie movieDtoToMovie(MovieDTO movieDTO) {
        if ( movieDTO == null ) {
            return null;
        }

        Movie movie = new Movie();

        movie.setMovie_id( movieDTO.getMovie_id() );
        movie.setName( movieDTO.getName() );
        movie.setMovie_content( movieDTO.getMovie_content() );
        movie.setEpisodes( movieDTO.getEpisodes() );
        movie.setMovie_schedule( movieDTO.getMovie_schedule() );
        movie.setImage( movieDTO.getImage() );
        movie.setCountry( movieDTO.getCountry() );
        movie.setStar( movieDTO.getStar() );
        movie.setPrice( movieDTO.getPrice() );
        movie.setViews( movieDTO.getViews() );
        movie.setStatus( movieDTO.getStatus() );
        movie.setEpisodeList( episodeDTOListToEpisodeList( movieDTO.getEpisodeList() ) );
        movie.setCategories( categoryDTOListToCategorySet( movieDTO.getCategories() ) );
        movie.setPersons( personDTOListToPersonSet( movieDTO.getPersons() ) );

        return movie;
    }

    private Integer movieCountryCountry_id(Movie movie) {
        if ( movie == null ) {
            return null;
        }
        Country country = movie.getCountry();
        if ( country == null ) {
            return null;
        }
        Integer country_id = country.getCountry_id();
        if ( country_id == null ) {
            return null;
        }
        return country_id;
    }

    protected EpisodeDTO episodeToEpisodeDTO(Episode episode) {
        if ( episode == null ) {
            return null;
        }

        EpisodeDTO episodeDTO = new EpisodeDTO();

        episodeDTO.setEpisode_id( episode.getEpisode_id() );
        episodeDTO.setName( episode.getName() );
        episodeDTO.setEpisode( episode.getEpisode() );
        episodeDTO.setSeason( episode.getSeason() );
        episodeDTO.setLink( episode.getLink() );
        episodeDTO.setDay_submit( episode.getDay_submit() );

        return episodeDTO;
    }

    protected List<EpisodeDTO> episodeListToEpisodeDTOList(List<Episode> list) {
        if ( list == null ) {
            return null;
        }

        List<EpisodeDTO> list1 = new ArrayList<EpisodeDTO>( list.size() );
        for ( Episode episode : list ) {
            list1.add( episodeToEpisodeDTO( episode ) );
        }

        return list1;
    }

    protected CategoryDTO categoryToCategoryDTO(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setCategory_id( category.getCategory_id() );
        categoryDTO.setName( category.getName() );

        return categoryDTO;
    }

    protected List<CategoryDTO> categorySetToCategoryDTOList(Set<Category> set) {
        if ( set == null ) {
            return null;
        }

        List<CategoryDTO> list = new ArrayList<CategoryDTO>( set.size() );
        for ( Category category : set ) {
            list.add( categoryToCategoryDTO( category ) );
        }

        return list;
    }

    protected PersonDTO personToPersonDTO(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        personDTO.setPerson_id( person.getPerson_id() );
        personDTO.setName( person.getName() );
        personDTO.setGender( person.getGender() );
        personDTO.setDay_of_birth( person.getDay_of_birth() );
        personDTO.setImage( person.getImage() );
        personDTO.setDescribe( person.getDescribe() );
        personDTO.setCountry( person.getCountry() );

        return personDTO;
    }

    protected List<PersonDTO> personSetToPersonDTOList(Set<Person> set) {
        if ( set == null ) {
            return null;
        }

        List<PersonDTO> list = new ArrayList<PersonDTO>( set.size() );
        for ( Person person : set ) {
            list.add( personToPersonDTO( person ) );
        }

        return list;
    }

    protected Episode episodeDTOToEpisode(EpisodeDTO episodeDTO) {
        if ( episodeDTO == null ) {
            return null;
        }

        Episode episode = new Episode();

        episode.setEpisode_id( episodeDTO.getEpisode_id() );
        episode.setName( episodeDTO.getName() );
        episode.setEpisode( episodeDTO.getEpisode() );
        episode.setSeason( episodeDTO.getSeason() );
        episode.setLink( episodeDTO.getLink() );
        episode.setDay_submit( episodeDTO.getDay_submit() );

        return episode;
    }

    protected List<Episode> episodeDTOListToEpisodeList(List<EpisodeDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Episode> list1 = new ArrayList<Episode>( list.size() );
        for ( EpisodeDTO episodeDTO : list ) {
            list1.add( episodeDTOToEpisode( episodeDTO ) );
        }

        return list1;
    }

    protected Category categoryDTOToCategory(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        Category category = new Category();

        category.setCategory_id( categoryDTO.getCategory_id() );
        category.setName( categoryDTO.getName() );

        return category;
    }

    protected Set<Category> categoryDTOListToCategorySet(List<CategoryDTO> list) {
        if ( list == null ) {
            return null;
        }

        Set<Category> set = new HashSet<Category>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( CategoryDTO categoryDTO : list ) {
            set.add( categoryDTOToCategory( categoryDTO ) );
        }

        return set;
    }

    protected Person personDTOToPerson(PersonDTO personDTO) {
        if ( personDTO == null ) {
            return null;
        }

        Person person = new Person();

        person.setPerson_id( personDTO.getPerson_id() );
        person.setName( personDTO.getName() );
        person.setGender( personDTO.getGender() );
        person.setDay_of_birth( personDTO.getDay_of_birth() );
        person.setImage( personDTO.getImage() );
        person.setDescribe( personDTO.getDescribe() );
        person.setCountry( personDTO.getCountry() );

        return person;
    }

    protected Set<Person> personDTOListToPersonSet(List<PersonDTO> list) {
        if ( list == null ) {
            return null;
        }

        Set<Person> set = new HashSet<Person>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( PersonDTO personDTO : list ) {
            set.add( personDTOToPerson( personDTO ) );
        }

        return set;
    }
}
